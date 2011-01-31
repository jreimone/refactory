/*
 * The FUJABA ToolSuite project:
 *
 *   FUJABA is the acronym for 'From Uml to Java And Back Again'
 *   and originally aims to provide an environment for round-trip
 *   engineering using UML as visual programming language. During
 *   the last years, the environment has become a base for several
 *   research activities, e.g. distributed software, database
 *   systems, modelling mechanical and electrical systems and
 *   their simulation. Thus, the environment has become a project,
 *   where this source code is part of. Further details are avail-
 *   able via http://www.fujaba.de
 *
 *      Copyright (C) Fujaba Development Group
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 *   MA 02111-1307, USA or download the license under
 *   http://www.gnu.org/copyleft/lesser.html
 *
 * WARRANTY:
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 * Contact address:
 *
 *   Fujaba Management Board
 *   Software Engineering Group
 *   University of Paderborn
 *   Warburgerstr. 100
 *   D-33098 Paderborn
 *   Germany
 *
 *   URL  : http://www.fujaba.de
 *   email: info@fujaba.de
 *
 */
package de.fujaba.preferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import de.uni_paderborn.fujaba.app.FujabaApp;
import de.uni_paderborn.fujaba.app.Version;
import de.uni_paderborn.fujaba.metamodel.common.FProject;

/**
 * !!! Modified to use different workspace !!!
 * 
 * Class 'PreferencesManager' is a facade that provides access to the
 * major functionality of the Fujaba preference mechanism.
 *
 * @author	  fklar
 * @author    (last editor) $Author: fklar $
 * @version   $Revision: 9531 $ $Date: 2009-07-07 16:08:12 +0200 (Tue, 07 Jul 2009) $
 */
public class PreferencesManager
{
   /**
    * The directory where the options are stored.
    */
   private static String baseDir = System.getProperty ("user.home");
   
   public static void setBaseDir(String baseDir) {  // !!! MODIFIED: NEW METHOD !!!
	   PreferencesManager.baseDir = baseDir;
   }
   
   /**
    * The file name of the properties file in which Fujaba remembers, which directory should be the 'propertyDir'.
    */
   public static final String PROPERTIES_PATH = baseDir + File.separator + "fujaba.properties";

   /**
    * Directory for all properties. Version number of fujaba is included, so different
    * fujaba-versions may have different settings.
    */
   private final static String PROPERTY_DIR = initializeDirectory();
   
   private static String initializeDirectory()
   {
      final Version version = Version.get();
      if (version.isAppPresent())
      {
         return version.getAppName() + version.getAppVersion();
      }
      else
      {
         return "fujaba" + version.getVersion();
      }
   }
   
   /**
    * PropertyName of the 'propertyDir' attribute.
    * Will be used in PropertyChangeEvents.
    */
   public final static String PROPERTY_DIR_PROPERTY = "propertyDir";

   /**
    * Key for the 'propertyDir' attribute that will be used
    * by FujabaApp to store the propertyDir in a (property) file.
    * <pre>
    *
    * Note: The key contains the fujaba base-directory
    *   (installation-directory) as keyword, so
    *   <b>every fujaba installation</b> (not every fujaba version)
    *   may define its own propertyDir.
    * </pre>
    */
   public final static String PROPERTY_DIR_KEY = new PropertyDirKey().toString();


   /**
    * Helper class that creates the key for the propertyDir.
    *
    * @author    $Author: fklar $
    * @version   $Revision: 9531 $ $Date: 2009-07-07 16:08:12 +0200 (Tue, 07 Jul 2009) $
    * @see       PreferencesManager#PROPERTY_DIR_KEY
    */
   public static class PropertyDirKey
   {
      @Override
      public String toString()
      {
         String[] parts = getParts();
         StringBuffer buffer = new StringBuffer();
         for (int i = 0; i < parts.length; i++)
         {
            buffer.append (parts[i]);
         }
         return buffer.toString();
      }


      /**
       * Get the parts that form the propertDir key.
       * The propertyDir key is equal to the concatenation of all parts.
       *
       * @return   An array that contains all parts of the propertyDir key.
       */
      public String[] getParts()
      {
         final Version version = Version.get();
         final int appMajor = version.isAppPresent() ? version.getAppMajor() : version.getMajor();
         final int appMinor = version.isAppPresent() ? version.getAppMinor() : version.getMinor();
         final String appVersion = appMajor + "." + appMinor;
         final String appName = version.getAppName();

         // we store
         //   application name,
         //   application version and
         //   application base directory
         // in the key, to be able to use different properties:
         // + for the same application installed in different directories
         // + for different app versions installed in the same directory
         String[] parts = new String[]{
            PROPERTY_DIR_PROPERTY,
            "_",
            appName,
            "_",
            appVersion,
            "_",
            String.valueOf( FujabaApp.FUJABA_BASE )
            };
         return parts;
      }
   }


   /**
    * Cache for property directory.
    *
    * <pre>
    * Note: changing property directory during runtime
    * is not recommended until Fujaba code has been reviewed.
    * </pre>
    */
   private static String propertyDir = null;


   /**
    * Get the directory in which Fujaba properties are stored.
    *
    * <pre>
    * Note: the propertyDir ends with a file separator.
    * Note: if the propertyDir has not been set, a call to
    *       this function will initialize the propertyDir with
    *       the proposedPropertyDir.
    * </pre>
    *
    * @return   The directory in which properties are stored.
    * @see      PreferencesManager#getProposedPropertyDir()
    */
   public static String getPropertyDir()
   {
      // use cached property directory, because property dir
      // should not change during runtime for now
      if (propertyDir == null)
      {
         setPropertyDir (getDefaultPropertyDir());
      }

      return propertyDir;
   }


   /**
    * Set the directory in which Fujaba properties are stored.
    *
    * <pre>
    *
    * Note: do not change propertyDir during runtime, for now!
    * Properties won't be adjusted, if the propertyDir changes.
    * Use startup-parameter in class 'FujabaApp' to change the
    * propertyDir during startup.
    * </pre>
    *
    * @param value
    * @see          de.uni_paderborn.fujaba.app.FujabaApp#main(String[])
    */
   public static void setPropertyDir (String value)
   {
      // make sure propertyDir ends with separator
      if (!value.endsWith (File.separator))
      {
         value += File.separator;
      }

      if (value != propertyDir)
      {
         propertyDir = value;
         // firePropertyChange(PROPERTY_DIR_PROPERTY, oldValue, value);
      }
   }


   /**
    * Get the default directory in which Fujaba properties should be stored. The directory-name is
    * constructed dependent on the version number of the fujaba application and is basically located
    * in the users home directory. Note: the propertyDir ends with a file separator.
    *
    * @return   The directory in which properties should be stored.
    */
   public static String getProposedPropertyDir()
   {
      StringBuffer propertyDirBuffer = new StringBuffer();

      propertyDirBuffer.append (baseDir);
      propertyDirBuffer.append (File.separatorChar);

      if ("Linux".equals (System.getProperty ("os.name"))
         || "Unix".equals (System.getProperty ("os.name")))
      {
         propertyDirBuffer.append (".");
      }

      propertyDirBuffer.append (PROPERTY_DIR);
      propertyDirBuffer.append (File.separatorChar);

      return propertyDirBuffer.toString();
   }

   public static String getDefaultPropertyDir ()
   {
      String propertyDir = null;
      // check if we have already stored a propertyDir
      propertyDir = getSavedPropertyDir();
      if (propertyDir != null)
      {
         // if the stored propertyDir does not exist, we use the
         // proposed propertyDir, because maybe someone has deleted
         // the propertyDir by hand, but forgot to edit the propertyFile
         // and the application name has changed... however we
         // show the proposed propertyDir to the user instead of
         // the last dir stored in the propertyfile, which doesn't exist any longer
         File propertyDirFile = new File(propertyDir);
         if (!(propertyDirFile.exists() && propertyDirFile.isDirectory()))
         {
            propertyDir = null;
         }
      }
      if (propertyDir==null)
      {
         propertyDir = getProposedPropertyDir();
      }
      return propertyDir;
   }
   
   public static String getSavedPropertyDir ()
   {
      String propertyDir = null;
      Properties propertyDirProperties = loadPropertyDirProperties();

      // does 'propertyDir' exist in file?
      if (propertyDirProperties != null)
      {
         propertyDir = propertyDirProperties
               .getProperty(PreferencesManager.PROPERTY_DIR_KEY);
      }
      return propertyDir;
   }


   private static Properties loadPropertyDirProperties ()
   {
      Properties propertyDirProperties = new Properties();
      File propertyDirPropertiesFile = new File(PROPERTIES_PATH);
      try
      {
         propertyDirProperties.load(new FileInputStream(
               propertyDirPropertiesFile));
      }
      catch (Exception e)
      {
      }
      return propertyDirProperties;
   }
   
   public static void savePropertyDir () throws IOException
   {
      // store propertyDir for next run
      Properties propertyDirProperties = loadPropertyDirProperties();
      propertyDirProperties.put(
            PreferencesManager.PROPERTY_DIR_KEY, propertyDir);

      File propertyDirPropertiesFile = new File(PROPERTIES_PATH);
      propertyDirProperties.store(new FileOutputStream(propertyDirPropertiesFile),
         "Fujaba Properties, Do NOT edit!");
   }
   
   public static FujabaPreferenceStore getFujabaPreferences()
   {
      return FujabaPreferenceStore.getInstance();
   }
   
   public static WorkspacePreferenceStore getWorkspacePreferences()
   {
      return WorkspacePreferenceStore.getInstance();
   }
   
   /**
    * Get preference store for the given project.
    * @param project A project. Should not be null.
    * @return The preference store of the given project. Null if project is null.
    */
   @SuppressWarnings("deprecation")
   public static ProjectPreferenceStore getProjectPreferences(FProject project)
   {
      if (project == null)
         return null;
      else
         return AbstractPreferenceStore.get(project);
   }
   
   /**
    * Get preference store for the given project or WorkspacePreferenceStore respectively.
    * @param project A project. May be null.
    * @return The preference store of the given project or the
    *         WorkspacePreferenceStore if project is null.
    */
   @SuppressWarnings("deprecation")
   public static AbstractPreferenceStore getProjectOrWorkspacePreferences(FProject project)
   {
      if (project == null)
         return WorkspacePreferenceStore.getInstance();
      else
         return AbstractPreferenceStore.get(project);
   }
   
   @SuppressWarnings("deprecation")
   public static PreferencesProxy getPreferencesProxy()
   {
      return PreferencesProxy.get();
   }
   
   @SuppressWarnings("deprecation")
   public static CodeGenerationDirectoryPreferenceStore getCodeGenerationDirectoryPreferences()
   {
      return CodeGenerationDirectoryPreferenceStore.get();
   }
   
   @SuppressWarnings("deprecation")
   public static LoggingPreferenceStore getLoggingPreferences()
   {
      return LoggingPreferenceStore.get();
   }
   
   @SuppressWarnings("deprecation")
   public static WindowPreferences getWindowPreferences()
   {
      return WindowPreferences.get();
   }
   
   /**
    * Plugins may register implementations of AbstractPreferenceStore via this method.
    * Preference stores of plugins will be searched for matching keys, whenever a key
    * can not be retrieved from the WorkspacePreferenceStore.
    * <p>
    * Class {@link PluginPreferenceStore} will operate on a AbstractPreferenceStore
    * passed to this method.
    * 
    * @param store An implementation of AbstractPreferenceStore. Typically
    *              an implementation of URLPreferenceStore or FilePreferenceStore.
    */
   @SuppressWarnings("deprecation")
   public static void registerPluginPreferenceStore(AbstractPreferenceStore store)
   {
      PluginPreferenceStore.registerPreferenceStore(store);
   }
}

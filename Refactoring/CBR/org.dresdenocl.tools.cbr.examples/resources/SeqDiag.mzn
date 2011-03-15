% Declarations (generated from the diagram/metamodel instance)

%<?xml version="1.0" encoding="UTF-8"?>
%<uml:Model xmi:version="2.1" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1" xmlns:uml="http://www.eclipse.org/uml2/3.0.0/UML" xmi:id="_qb8akM37EdqwVrslYOdUDA">
%  <packagedElement xmi:type="uml:Package" xmi:id="_w8IxIM37EdqwVrslYOdUDA" name="SequenceDIagram">

% class Directory
%    <packagedElement xmi:type="uml:Class" xmi:id="_hl2E4BmsEeCYb_r36PiY5g" name="Directory">
par int: ID_hl2E4BmsEeCYb_r36PiY5g = 0;
par string: ID_hl2E4BmsEeCYb_r36PiY5g_name = "Directory";
%      <generalization xmi:id="_q_Co4xmsEeCYb_r36PiY5g" general="_hunmaBmsEeCYb_r36PiY5g"/>
par set of ID_hl2E4BmsEeCYb_r36PiY5g..ID_pInSwBmsEeCYb_r36PiY5g: ID_hl2E4BmsEeCYb_r36PiY5g_superClass = ID_hunmaBmsEeCYb_r36PiY5g..ID_hunmaBmsEeCYb_r36PiY5g;

% operation find
%      <ownedOperation xmi:id="_tUQMwBmsEeCYb_r36PiY5g" name="find"/>
par int    : ID_tUQMwBmsEeCYb_r36PiY5g      = 12;
par string : ID_tUQMwBmsEeCYb_r36PiY5g_name = "find";
var int    : ID_tUQMwBmsEeCYb_r36PiY5g_class; % initial value = ID_hl2E4BmsEeCYb_r36PiY5g; % Achtung: manuell erzeugt!

%    </packagedElement>

% class Content
%    <packagedElement xmi:type="uml:Class" xmi:id="_hunmaBmsEeCYb_r36PiY5g" name="Content"/>
par int: ID_hunmaBmsEeCYb_r36PiY5g = 1;
par string: ID_hunmaBmsEeCYb_r36PiY5g_name = "Content";
par set of ID_hl2E4BmsEeCYb_r36PiY5g..ID_pInSwBmsEeCYb_r36PiY5g: ID_hunmaBmsEeCYb_r36PiY5g_superClass = 1..0;

% class File
%    <packagedElement xmi:type="uml:Class" xmi:id="_pInSwBmsEeCYb_r36PiY5g" name="File">
par int: ID_pInSwBmsEeCYb_r36PiY5g = 2;
par string: ID_pInSwBmsEeCYb_r36PiY5g_name = "File";
%      <generalization xmi:id="_rlkdYBmsEeCYb_r36PiY5g" general="_hunmaBmsEeCYb_r36PiY5g"/>
par set of ID_hl2E4BmsEeCYb_r36PiY5g..ID_pInSwBmsEeCYb_r36PiY5g: ID_pInSwBmsEeCYb_r36PiY5g_superClass = ID_hunmaBmsEeCYb_r36PiY5g..ID_hunmaBmsEeCYb_r36PiY5g;

% operation getName
%      <ownedOperation xmi:id="_um-Y4hmsEeCYb_r36PiY5g" name="getName"/>
par int    : ID_um_Y4hmsEeCYb_r36PiY5g      = 13;        % "-" durch "_" ersetzt!
par string : ID_um_Y4hmsEeCYb_r36PiY5g_name = "getName"; % "-" durch "_" ersetzt!
var int    : ID_um_Y4hmsEeCYb_r36PiY5g_class; % initial value = ID_pInSwBmsEeCYb_r36PiY5g % Achtung: manuell erzeugt!

%    </packagedElement>
	
%    <packagedElement xmi:type="uml:Collaboration" xmi:id="_xE07YBmsEeCYb_r36PiY5g">

% interaction 
%      <ownedBehavior xmi:type="uml:Interaction" xmi:id="_xE07YRmsEeCYb_r36PiY5g">
par int: ID_xE07YRmsEeCYb_r36PiY5g = 3;

% property Property1
%        <ownedAttribute xmi:id="_zPxwABmsEeCYb_r36PiY5g" name="Property1" type="_hl2E4BmsEeCYb_r36PiY5g"/>
par int: ID_zPxwABmsEeCYb_r36PiY5g = 4;
par string: ID_zPxwABmsEeCYb_r36PiY5g_name = "Property1";
var int: ID_zPxwABmsEeCYb_r36PiY5g_type; % initial value = ID_hl2E4BmsEeCYb_r36PiY5g;

% property Property2
%        <ownedAttribute xmi:id="_1k2J8BmsEeCYb_r36PiY5g" name="Property2" type="_pInSwBmsEeCYb_r36PiY5g"/>
par int: ID_1k2J8BmsEeCYb_r36PiY5g = 5;
par string: ID_1k2J8BmsEeCYb_r36PiY5g_name = "Property2";
var int: ID_1k2J8BmsEeCYb_r36PiY5g_type; % initial value = ID_pInSwBmsEeCYb_r36PiY5g;

%        <ownedConnector xmi:id="_zPxwARmsEeCYb_r36PiY5g" name="Connector1">
%          <end xmi:id="_zPxwAhmsEeCYb_r36PiY5g" role="_zPxwABmsEeCYb_r36PiY5g"/>
%          <end xmi:id="_1k2J8RmsEeCYb_r36PiY5g" role="_1k2J8BmsEeCYb_r36PiY5g"/>
%        </ownedConnector>

% lifeline d		
%        <lifeline xmi:id="_xlQH4BmsEeCYb_r36PiY5g" name="d" represents="_zPxwABmsEeCYb_r36PiY5g" coveredBy="_FbDNoBmtEeCYb_r36PiY5g _2k-KMhmsEeCYb_r36PiY5g"/>
par int        : ID_xlQH4BmsEeCYb_r36PiY5g = 6; 
par string     : ID_xlQH4BmsEeCYb_r36PiY5g_name ="d";
par set of int : ID_xlQH4BmsEeCYb_r36PiY5g_represents = ID_zPxwABmsEeCYb_r36PiY5g..ID_zPxwABmsEeCYb_r36PiY5g;
%par set of int : ID_xlQH4BmsEeCYb_r36PiY5g_coveredBy = ID_FbDNoBmtEeCYb_r36PiY5g..ID_2k-KMhmsEeCYb_r36PiY5g; %??

% lifeline f
%        <lifeline xmi:id="_0zwEMBmsEeCYb_r36PiY5g" name="f" represents="_1k2J8BmsEeCYb_r36PiY5g" coveredBy="_FbDNoRmtEeCYb_r36PiY5g _3dDowhmsEeCYb_r36PiY5g"/>
par int        : ID_0zwEMBmsEeCYb_r36PiY5g = 7;
par string     : ID_0zwEMBmsEeCYb_r36PiY5g_name = "f";
par set of int : ID_0zwEMBmsEeCYb_r36PiY5g_represents = ID_1k2J8BmsEeCYb_r36PiY5g..ID_1k2J8BmsEeCYb_r36PiY5g; 
%par set of int : ID_0zwEMBmsEeCYb_r36PiY5g_coveredBy = ID_FbDNoRmtEeCYb_r36PiY5g .. ID_3dDowhmsEeCYb_r36PiY5g; %??


% MessageOccurrenceSpecification1
%        <fragment xmi:type="uml:MessageOccurrenceSpecification" xmi:id="_FbDNoBmtEeCYb_r36PiY5g" name="MessageOccurrenceSpecification1" covered="_xlQH4BmsEeCYb_r36PiY5g" event="_FbDNohmtEeCYb_r36PiY5g" message="_FbDNoxmtEeCYb_r36PiY5g"/>
par int        : ID_FbDNoBmtEeCYb_r36PiY5g         = 8;
par string     : ID_FbDNoBmtEeCYb_r36PiY5g_name    = "MessageOccurrenceSpecification1";
par set of int : ID_FbDNoBmtEeCYb_r36PiY5g_covered = ID_xlQH4BmsEeCYb_r36PiY5g..ID_xlQH4BmsEeCYb_r36PiY5g;
par int        : ID_FbDNoBmtEeCYb_r36PiY5g_event   = ID_FbDNohmtEeCYb_r36PiY5g;

%        <fragment xmi:type="uml:MessageOccurrenceSpecification" xmi:id="_FbDNoRmtEeCYb_r36PiY5g" name="MessageOccurrenceSpecification2" covered="_0zwEMBmsEeCYb_r36PiY5g" event="_FbDNohmtEeCYb_r36PiY5g" message="_FbDNoxmtEeCYb_r36PiY5g"/>
par int        : ID_FbDNoRmtEeCYb_r36PiY5g         = 9;
par string     : ID_FbDNoRmtEeCYb_r36PiY5g_name    = "MessageOccurrenceSpecification2";
par set of int : ID_FbDNoRmtEeCYb_r36PiY5g_covered = ID_0zwEMBmsEeCYb_r36PiY5g..ID_0zwEMBmsEeCYb_r36PiY5g;
par int        : ID_FbDNoRmtEeCYb_r36PiY5g_event   = ID_FbDNohmtEeCYb_r36PiY5g;

%        <fragment xmi:type="uml:BehaviorExecutionSpecification" xmi:id="_2k-KMhmsEeCYb_r36PiY5g" name="BehaviorExecutionSpecification1" covered="_xlQH4BmsEeCYb_r36PiY5g" start="_FbDNoBmtEeCYb_r36PiY5g" finish="_FbDNoBmtEeCYb_r36PiY5g"/>
%        <fragment xmi:type="uml:BehaviorExecutionSpecification" xmi:id="_3dDowhmsEeCYb_r36PiY5g" name="BehaviorExecutionSpecification2" covered="_0zwEMBmsEeCYb_r36PiY5g" start="_FbDNoRmtEeCYb_r36PiY5g" finish="_FbDNoRmtEeCYb_r36PiY5g"/>

% message getName
%        <message xmi:id="_FbDNoxmtEeCYb_r36PiY5g" name="getName" receiveEvent="_FbDNoRmtEeCYb_r36PiY5g" sendEvent="_FbDNoBmtEeCYb_r36PiY5g"/>
par int        : ID_FbDNoxmtEeCYb_r36PiY5g              = 10;
par string     : ID_FbDNoxmtEeCYb_r36PiY5g_name         = "getName";
par int        : ID_FbDNoxmtEeCYb_r36PiY5g_receiveEvent = ID_FbDNoRmtEeCYb_r36PiY5g;

%		</ownedBehavior>
%    </packagedElement>

% CallEvent1
%    <packagedElement xmi:type="uml:CallEvent" xmi:id="_FbDNohmtEeCYb_r36PiY5g" name="CallEvent1" operation="_6DIUoh-2EeCz3u46NAB45Q"/>
par int : ID_FbDNohmtEeCYb_r36PiY5g = 11;
par string : ID_FbDNohmtEeCYb_r36PiY5g_name = "CallEvent1";
par int : ID_FbDNohmtEeCYb_r36PiY5g_operation = 0;% eigtl.: ID_6DIUoh-2EeCz3u46NAB45Q; % falsch -- wieso getSize? wieso Klasse SuperFile (s.u.)


%    <packagedElement xmi:type="uml:Association" xmi:id="_WPLlsB4tEeCQTbbZHixhAw" name="A_&lt;directory>_&lt;content>" memberEnd="_WPLlsR4tEeCQTbbZHixhAw _WPLltB4tEeCQTbbZHixhAw">
%     <ownedEnd xmi:id="_WPLlsR4tEeCQTbbZHixhAw" name="directory" type="_hl2E4BmsEeCYb_r36PiY5g" association="_WPLlsB4tEeCQTbbZHixhAw">
%        <lowerValue xmi:type="uml:LiteralInteger" xmi:id="_WPLlsx4tEeCQTbbZHixhAw" value="1"/>
%      </ownedEnd>
%      <ownedEnd xmi:id="_WPLltB4tEeCQTbbZHixhAw" name="content" type="_hunmaBmsEeCYb_r36PiY5g" aggregation="shared" association="_WPLlsB4tEeCQTbbZHixhAw">
%        <upperValue xmi:type="uml:LiteralUnlimitedNatural" xmi:id="_WPLltR4tEeCQTbbZHixhAw" value="1"/>
%        <lowerValue xmi:type="uml:LiteralInteger" xmi:id="_WPLlth4tEeCQTbbZHixhAw" value="1"/>
%      </ownedEnd>
%    </packagedElement>
%    <packagedElement xmi:type="uml:Class" xmi:id="_4ilH4B-2EeCz3u46NAB45Q" name="SuperFile">
%      <ownedOperation xmi:id="_6DIUoh-2EeCz3u46NAB45Q" name="getSize"/>
%    </packagedElement>
%  </packagedElement>
%</uml:Model>


% Constraints (generated from the WFR)

	% Cardinalities
		%constraint card(ID_zPxwABmsEeCYb_r36PiY5g_type) <= 1; % derzeit noch nicht mengenwertig;
		%constraint card(ID_1k2J8BmsEeCYb_r36PiY5g_type) <= 1; % derzeit noch nicht mengenwertig;
	% Other
		constraint ((ID_hl2E4BmsEeCYb_r36PiY5g = ID_zPxwABmsEeCYb_r36PiY5g_type) -> (ID_tUQMwBmsEeCYb_r36PiY5g_class = ID_hl2E4BmsEeCYb_r36PiY5g \/ (ID_tUQMwBmsEeCYb_r36PiY5g_class in ID_hl2E4BmsEeCYb_r36PiY5g_superClass)));
		constraint ((ID_pInSwBmsEeCYb_r36PiY5g = ID_zPxwABmsEeCYb_r36PiY5g_type) -> (ID_tUQMwBmsEeCYb_r36PiY5g_class = ID_pInSwBmsEeCYb_r36PiY5g \/ (ID_tUQMwBmsEeCYb_r36PiY5g_class in ID_pInSwBmsEeCYb_r36PiY5g_superClass)));
		constraint ((ID_hunmaBmsEeCYb_r36PiY5g = ID_zPxwABmsEeCYb_r36PiY5g_type) -> (ID_tUQMwBmsEeCYb_r36PiY5g_class = ID_hunmaBmsEeCYb_r36PiY5g \/ (ID_tUQMwBmsEeCYb_r36PiY5g_class in ID_hunmaBmsEeCYb_r36PiY5g_superClass)));
		constraint ((ID_hl2E4BmsEeCYb_r36PiY5g = ID_1k2J8BmsEeCYb_r36PiY5g_type) -> (ID_um_Y4hmsEeCYb_r36PiY5g_class = ID_hl2E4BmsEeCYb_r36PiY5g \/ (ID_um_Y4hmsEeCYb_r36PiY5g_class in ID_hl2E4BmsEeCYb_r36PiY5g_superClass)));
		constraint ((ID_pInSwBmsEeCYb_r36PiY5g = ID_1k2J8BmsEeCYb_r36PiY5g_type) -> (ID_um_Y4hmsEeCYb_r36PiY5g_class = ID_pInSwBmsEeCYb_r36PiY5g \/ (ID_um_Y4hmsEeCYb_r36PiY5g_class in ID_pInSwBmsEeCYb_r36PiY5g_superClass)));
		constraint ((ID_hunmaBmsEeCYb_r36PiY5g = ID_1k2J8BmsEeCYb_r36PiY5g_type) -> (ID_um_Y4hmsEeCYb_r36PiY5g_class = ID_hunmaBmsEeCYb_r36PiY5g \/ (ID_um_Y4hmsEeCYb_r36PiY5g_class in ID_hunmaBmsEeCYb_r36PiY5g_superClass)));

solve satisfy;

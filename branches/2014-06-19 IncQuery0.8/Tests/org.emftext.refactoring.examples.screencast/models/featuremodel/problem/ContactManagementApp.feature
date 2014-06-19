<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="Contact Management Features">
  <constraints language="OWL" expression="conflicts" constrainedFeatures="MultipleAssignment Highrise"/>
  <root name="ContactManagement" minCardinality="1" maxCardinality="1">
    <groups maxCardinality="4">
      <childFeatures name="Addresses" maxCardinality="1"/>
      <childFeatures name="Relationships" maxCardinality="1"/>
      <childFeatures name="ContactOpportunities" maxCardinality="1"/>
      <childFeatures name="Notes" maxCardinality="1"/>
      <childFeatures name="Groups" maxCardinality="1">
        <groups maxCardinality="2">
          <childFeatures name="MultipleAssignment" maxCardinality="1" constraints="//@constraints.0"/>
          <childFeatures name="ArbitraryDepth" maxCardinality="1"/>
        </groups>
      </childFeatures>
      <childFeatures name="Synchronisation" maxCardinality="1">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures name="GMail" maxCardinality="1"/>
          <childFeatures name="Highrise" maxCardinality="1" constraints="//@constraints.0"/>
          <childFeatures name="MobilePhone" maxCardinality="1"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>

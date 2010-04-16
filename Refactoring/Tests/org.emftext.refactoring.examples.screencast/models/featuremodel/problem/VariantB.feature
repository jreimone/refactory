<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="Contact Management Features">
  <root name="ContactManagement">
    <groups maxCardinality="4">
      <childFeatures name="Addresses"/>
      <childFeatures name="Relationships"/>
      <childFeatures name="ContactOpportunities"/>
      <childFeatures name="Notes"/>
      <childFeatures name="Groups">
        <groups>
          <childFeatures name="MultipleAssignment"/>
          <childFeatures name="ArbitraryDepth"/>
        </groups>
      </childFeatures>
      <childFeatures name="Synchronisation" maxCardinality="1">
        <groups>
          <childFeatures name="GMail" maxCardinality="1"/>
          <childFeatures name="MobilePhone" maxCardinality="1"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>

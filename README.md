# Java-WebSocket-with-SpringBoot

This repo is a basic demonstration of seocket programming with java using SpringBoot.

Objective : 
XML (From 3rd pary) ----> webSocketAPI---> SyncServer(Backend)Springboot --------> Store locally(MAP) ------> expose restAPIS to get the xml attributes and tags 

WEBSocket URL: ws://localhost:8080/api/xmlDataSync <-- call with xml message to initiate the sync
REST endPoint : localhost:8080/api/getByItemCode?id=1234  <-- use this endpoint to get the details of item by Id

Note::: for XML sync to backend(websocket call to backend) can be made from webbrowser as well :
kindly run the springboot project and open http://localhost:8080/index.html and use sample xml given below then you can use rest end point to fetch the item detials.

Note::: Applicatioin will not allow you to sync same ids 

Note::: I've not used any database here so once you stop the connection data will be cleared from memory. This can be fixed using database service.

Data to be used as sample:
XML sample: https://github.com/shrey01/Java-WebSocket-with-SpringBoot/tree/main/src/main/resources/mockData

<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE item>
<item>
   <itemCode id="1234">
      <description>Item description is ef87c97d-344a-47c5-86c8-6addd2d4c6ae</description>
   </itemCode>
    <itemCode id="4334">
      <description>Item description is d0b5103a-571b-4cb4-b97c-6e2b14675fdf</description>
   </itemCode>
    <itemCode id="4325">
      <description>Item description is 7f4d0392-f36a-40d2-ae2a-bd9df8989b16</description>
   </itemCode>
    <itemCode id="6745">
      <description>Item description is 05d43de0-68f8-4acd-a9e1-ce647cb5b7c5</description>
   </itemCode>
    <itemCode id="4536">
      <description>Item description is 5b4c2c52-06a9-421b-9b63-d04b3df8ae64</description>
   </itemCode>
    <itemCode id="7653">
      <description>Item description is 1fe9b61d-0d7d-42e6-8911-cd4560f26c3e</description>
   </itemCode>
    <itemCode id="7426">
      <description>Item description is 21b0e4aa-211b-4907-80d2-0a209cdcb4f1</description>
   </itemCode>
    <itemCode id="1352">
      <description>Item description is d03a6c7b-8227-44f4-8d77-d58eaf666a34</description>
   </itemCode>
    <itemCode id="1235">
      <description>Item description is 1178f6b5-744b-4af1-bf15-e33b48a90c5a</description>
   </itemCode>
 </item>
 
 
 XML xsd:
 
 <xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
  <xs:element name="item" type="itemType"/>
  <xs:complexType name="itemCodeType">
    <xs:sequence>
      <xs:element type="xs:string" name="description"/>
    </xs:sequence>
    <xs:attribute type="xs:short" name="id" use="optional"/>
  </xs:complexType>
  <xs:complexType name="itemType">
    <xs:sequence>
      <xs:element type="itemCodeType" name="itemCode" maxOccurs="unbounded" minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>
</xs:schema>

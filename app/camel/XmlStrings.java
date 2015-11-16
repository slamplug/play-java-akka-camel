package camel;

/**
 * Created by slamplugh on 05/11/2015.
 */
public class XmlStrings {

    public static final String plainCotXml = "<communication>\n" +
            "    <eventType>COT Plain</eventType>\n" +
            "    <eventStatus>Acknowledged</eventStatus>\n" +
            "    <customers>\n" +
            "        <customer>\n" +
            "            <customerNumber>550001</customerNumber>\n" +
            "            <properties>\n" +
            "                <property>\n" +
            "                    <name>EVENT_ROLE</name>\n" +
            "                    <value>Initiator</value>\n" +
            "                </property>\n" +
            "                <property>\n" +
            "                    <name>CUSTOMER_ROLE</name>\n" +
            "                    <value>MOVING_IN</value>\n" +
            "                </property>\n" +
            "            </properties>\n" +
            "        </customer>\n" +
            "        <customer>\n" +
            "            <customerNumber>550002</customerNumber>\n" +
            "            <properties>\n" +
            "                <property>\n" +
            "                    <name>EVENT_ROLE</name>\n" +
            "                    <value>Affected</value>\n" +
            "                </property>\n" +
            "                <property>\n" +
            "                    <name>CUSTOMER_ROLE</name>\n" +
            "                    <value>MOVING_OUT</value>\n" +
            "                </property>\n" +
            "            </properties>\n" +
            "        </customer>\n" +
            "    </customers>\n" +
            "</communication>";

    public static final String customer550001 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<response>\n" +
            "    <ok>\n" +
            "        <customers>\n" +
            "            <customer>\n" +
            "                <customerid>123456</customerid>\n" +
            "                <customerno>550001</customerno>\n" +
            "                <title>Mr. Peter Piper</title>\n" +
            "                <type>Residential</type>\n" +
            "                <billingContactMethod>eBilling</billingContactMethod>\n" +
            "                <billedbalance>-288.83</billedbalance>\n" +
            "                <billcycle>Default</billcycle>\n" +
            "                <unbilledbalance>-46.68</unbilledbalance>\n" +
            "                <deposit></deposit>\n" +
            "                <installment></installment>\n" +
            "                <paymentmethod>Direct Debit</paymentmethod>\n" +
            "                <status>Cancelled</status>\n" +
            "                <banks>\n" +
            "                    <bank>\n" +
            "                        <branch>Smile</branch>\n" +
            "                        <accountsortcode>010203</accountsortcode>\n" +
            "                        <accountnumber>12345678</accountnumber>\n" +
            "                        <accountname>Peter Piper</accountname>\n" +
            "                        <secondSignatureRequired></secondSignatureRequired>\n" +
            "                        <startdate>2013-10-10T15:51:35+0000</startdate>\n" +
            "                    </bank>\n" +
            "                </banks>\n" +
            "                <addresses>\n" +
            "                    <address>\n" +
            "                        <type>Billing</type>\n" +
            "                        <postcode>BB12TT</postcode>\n" +
            "                        <addressline1>62</addressline1>\n" +
            "                        <addressline2>SOME LANE</addressline2>\n" +
            "                        <addressline3></addressline3>\n" +
            "                        <addressline4>BIRMINGHAM</addressline4>\n" +
            "                        <addressline5></addressline5>\n" +
            "                        <addressline6></addressline6>\n" +
            "                        <addressline7></addressline7>\n" +
            "                        <addressline8></addressline8>\n" +
            "                        <addressline9></addressline9>\n" +
            "                    </address>\n" +
            "                    <address>\n" +
            "                        <type>Contact</type>\n" +
            "                        <postcode>BB12TT</postcode>\n" +
            "                        <addressline1>62</addressline1>\n" +
            "                        <addressline2>SOME LANE</addressline2>\n" +
            "                        <addressline3></addressline3>\n" +
            "                        <addressline4>BIRMINGHAM</addressline4>\n" +
            "                        <addressline5></addressline5>\n" +
            "                        <addressline6></addressline6>\n" +
            "                        <addressline7></addressline7>\n" +
            "                        <addressline8></addressline8>\n" +
            "                        <addressline9></addressline9>\n" +
            "                    </address>\n" +
            "                </addresses>\n" +
            "                <contacts>\n" +
            "                    <contact>\n" +
            "                        <type>Default</type>\n" +
            "                        <format>Email</format>\n" +
            "                        <contact>peterpiper@gmail.com</contact>\n" +
            "                    </contact>\n" +
            "                    <contact>\n" +
            "                        <type>Personal</type>\n" +
            "                        <format>Phone Number Home</format>\n" +
            "                        <contact>07890123456</contact>\n" +
            "                    </contact>\n" +
            "                    <contact>\n" +
            "                        <type>Personal</type>\n" +
            "                        <format>Mobile</format>\n" +
            "                        <contact>07890123456</contact>\n" +
            "                    </contact>\n" +
            "                </contacts>\n" +
            "                <endpoints>\n" +
            "                    <endpoint>\n" +
            "                        <type>MPRN</type>\n" +
            "                        <serial_value>2420868405</serial_value>\n" +
            "                        <is_active>false</is_active>\n" +
            "                        <enddate>2015-10-25T23:59:59+0000</enddate>\n" +
            "                        <startdate>2013-10-10T00:00:00+0000</startdate>\n" +
            "                        <energization_status>1</energization_status>\n" +
            "                        <disconnection_status>1</disconnection_status>\n" +
            "                    </endpoint>\n" +
            "                    <endpoint>\n" +
            "                        <type>MPAN</type>\n" +
            "                        <serial_value>1100025251919</serial_value>\n" +
            "                        <is_active>false</is_active>\n" +
            "                        <enddate>2015-10-25T23:59:59+0000</enddate>\n" +
            "                        <startdate>2013-10-10T00:00:00+0000</startdate>\n" +
            "                        <energization_status>1</energization_status>\n" +
            "                        <disconnection_status>1</disconnection_status>\n" +
            "                    </endpoint>\n" +
            "                </endpoints>\n" +
            "                <paymentterms>\n" +
            "                    <paymentterm>\n" +
            "                        <id>1831803</id>\n" +
            "                        <is_active>false</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>124</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2013-10-11T00:00:00+0000</startdate>\n" +
            "                        <enddate>2014-05-21T15:49:35+0000</enddate>\n" +
            "                        <updatedate>2014-05-21T15:49:35+0000</updatedate>\n" +
            "                        <pulldate>12</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                    <paymentterm>\n" +
            "                        <id>22071608</id>\n" +
            "                        <is_active>false</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>117</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2014-05-21T15:49:35+0000</startdate>\n" +
            "                        <enddate>2014-10-23T09:46:37+0000</enddate>\n" +
            "                        <updatedate>2014-10-23T09:46:37+0000</updatedate>\n" +
            "                        <pulldate>12</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                    <paymentterm>\n" +
            "                        <id>36515776</id>\n" +
            "                        <is_active>true</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>124</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2014-10-23T09:46:37+0000</startdate>\n" +
            "                        <enddate>2015-05-26T00:00:00+0000</enddate>\n" +
            "                        <updatedate>2015-05-26T09:40:11+0000</updatedate>\n" +
            "                        <pulldate>12</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                    <paymentterm>\n" +
            "                        <id>93375840</id>\n" +
            "                        <is_active>false</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>100</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2015-10-22T00:00:00+0000</startdate>\n" +
            "                        <enddate>2015-10-25T23:59:59+0000</enddate>\n" +
            "                        <updatedate>2015-10-26T15:34:45+0000</updatedate>\n" +
            "                        <pulldate>12</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                    <paymentterm>\n" +
            "                        <id>76318173</id>\n" +
            "                        <is_active>true</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>109</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2015-07-21T00:00:00+0000</startdate>\n" +
            "                        <enddate>2015-10-22T00:00:00+0000</enddate>\n" +
            "                        <updatedate>2015-10-26T08:03:57+0000</updatedate>\n" +
            "                        <pulldate>12</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                    <paymentterm>\n" +
            "                        <id>65863960</id>\n" +
            "                        <is_active>true</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>109</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2015-05-26T00:00:00+0000</startdate>\n" +
            "                        <enddate>2015-06-24T00:00:00+0000</enddate>\n" +
            "                        <updatedate>2015-06-24T17:34:44+0000</updatedate>\n" +
            "                        <pulldate>12</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                    <paymentterm>\n" +
            "                        <id>71618597</id>\n" +
            "                        <is_active>true</is_active>\n" +
            "                        <type>Fixed Direct Debit</type>\n" +
            "                        <amount>109</amount>\n" +
            "                        <frequency>Monthly</frequency>\n" +
            "                        <startdate>2015-06-24T00:00:00+0000</startdate>\n" +
            "                        <enddate>2015-07-21T00:00:00+0000</enddate>\n" +
            "                        <updatedate>2015-07-21T19:13:16+0000</updatedate>\n" +
            "                        <pulldate>10</pulldate>\n" +
            "                    </paymentterm>\n" +
            "                </paymentterms>\n" +
            "                <remarks/>\n" +
            "                <properties>\n" +
            "                    <property>\n" +
            "                        <name>Acquisition Channel</name>\n" +
            "                        <value>WEB_SITE</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Registration ID</name>\n" +
            "                        <value>439704</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Agent Code</name>\n" +
            "                        <value>FRSTUTIL2</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Customer Last Generation Run Date</name>\n" +
            "                        <value>2015-10-08T00:00:00+0000</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Title</name>\n" +
            "                        <value>3</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>First Name</name>\n" +
            "                        <value>Peter</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Last Name</name>\n" +
            "                        <value>Piper</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Company Name</name>\n" +
            "                        <value>Default Company</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Generated Unique ID</name>\n" +
            "                        <value>93600dd1-4a29-4528-a19c-8a742d731645</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Birthday</name>\n" +
            "                        <value>1974-11-01T00:00:00+0000</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Generation status</name>\n" +
            "                        <value>1</value>\n" +
            "                    </property>\n" +
            "                </properties>\n" +
            "            </customer>\n" +
            "        </customers>\n" +
            "        <requestId>1160272616</requestId>\n" +
            "    </ok>\n" +
            "</response>";

    public static final String customer550002 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<response>\n" +
            "    <ok>\n" +
            "        <customers>\n" +
            "            <customer>\n" +
            "                <customerid>1249123</customerid>\n" +
            "                <customerno>1984690</customerno>\n" +
            "                <title>Owner Occupier</title>\n" +
            "                <type>Residential</type>\n" +
            "                <billingContactMethod>Paper</billingContactMethod>\n" +
            "                <billedbalance>0</billedbalance>\n" +
            "                <billcycle>Default</billcycle>\n" +
            "                <unbilledbalance>0</unbilledbalance>\n" +
            "                <deposit></deposit>\n" +
            "                <installment>0</installment>\n" +
            "                <paymentmethod>Cheque</paymentmethod>\n" +
            "                <status>Prospect</status>\n" +
            "                <banks/>\n" +
            "                <addresses>\n" +
            "                    <address>\n" +
            "                        <type>Billing</type>\n" +
            "                        <postcode>BB12TT</postcode>\n" +
            "                        <addressline1>62</addressline1>\n" +
            "                        <addressline2>SOME LANE</addressline2>\n" +
            "                        <addressline3></addressline3>\n" +
            "                        <addressline4>BIRMINGHAM</addressline4>\n" +
            "                        <addressline5></addressline5>\n" +
            "                        <addressline6></addressline6>\n" +
            "                        <addressline7></addressline7>\n" +
            "                        <addressline8></addressline8>\n" +
            "                        <addressline9></addressline9>\n" +
            "                    </address>\n" +
            "                </addresses>\n" +
            "                <contacts/>\n" +
            "                <endpoints/>\n" +
            "                <paymentterms/>\n" +
            "                <remarks/>\n" +
            "                <properties>\n" +
            "                    <property>\n" +
            "                        <name>Title</name>\n" +
            "                        <value>3</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>First Name</name>\n" +
            "                        <value>Owner</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Last Name</name>\n" +
            "                        <value>Occupier</value>\n" +
            "                    </property>\n" +
            "                    <property>\n" +
            "                        <name>Company Name</name>\n" +
            "                        <value>Default Company</value>\n" +
            "                    </property>\n" +
            "                </properties>\n" +
            "            </customer>\n" +
            "        </customers>\n" +
            "        <requestId>1162674583</requestId>\n" +
            "    </ok>\n" +
            "</response>";

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antexpert;

/**
 *
 * @author aseer
 */
public class DeployProp {
    
    public static String tasktype;
    public static String isCheck;
    public static String isRollback;
    
    
    public static String build_xml = "<project name=\"Sample usage of Salesforce Ant tasks\" default=\"test\" basedir=\".\" xmlns:sf=\"antlib:com.salesforce\">\n" +
            "\n" +
            "    <property file=\"build.properties\"/>\n" +
            "    <property environment=\"env\"/>\n" +
            "\n" +
            "    <!-- Setting default value for username, password and session id properties to empty string \n" +
            "         so unset values are treated as empty. Without this, ant expressions such as ${sf.username}\n" +
            "         will be treated literally.\n" +
            "    -->\n" +
            "    <condition property=\"sf.username\" value=\"\"> <not> <isset property=\"sf.username\"/> </not> </condition>\n" +
            "    <condition property=\"sf.password\" value=\"\"> <not> <isset property=\"sf.password\"/> </not> </condition>\n" +
            "    <condition property=\"sf.sessionId\" value=\"\"> <not> <isset property=\"sf.sessionId\"/> </not> </condition>\n" +
            "\n" +
            "    <taskdef resource=\"com/salesforce/antlib.xml\" uri=\"antlib:com.salesforce\">\n" +
            "        <classpath>\n" +
            "            <pathelement location=\"../ant-salesforce.jar\" />        	\n" +
            "        </classpath>\n" +
            "    </taskdef>\n" +
            "	\n" +
            "   \n" +
            "    <!-- Shows retrieving code; only succeeds if done after deployCode -->\n" +
            "    <target name=\"retreive\">\n" +
            "      <mkdir dir=\"retreivedSource\"/>\n" +
            "      <!-- Retrieve the contents listed in the file codepkg/package.xml into the codepkg directory -->\n" +
            "      <sf:retrieve username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\"\n" +
            "   serverurl=\"${sf.serverurl}\" maxPoll=\"${sf.maxPoll}\" retrieveTarget=\"retreivedSource\" unpackaged=\"retreive/package.xml\"/>\n" +
            "    </target>\n" +
            "	\n" +
            "    <!-- Shows deploying code & running tests for code in directory -->\n" +
            "    <target name=\"deployCheckSpecific\">\n" +
            "      <!-- Upload the contents of the \"codepkg\" directory, running the tests for just 1 class -->\n" +
            "      <sf:deploy username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\"\n" +
            " maxPoll=\"${sf.maxPoll}\" checkOnly=\"true\" deployRoot=\"retreivedSource\" testLevel=\"RunSpecifiedTests\" rollbackOnError=\"true\">\n" +
            " \n" +
            "	<runTest>VST_RosesControllerTest</runTest> \n" +
            "	\n" +
            "      </sf:deploy>\n" +
            "    </target>\n" +
            "\n" +
            "    <!--Shows deploying code with no TestLevel sepcified-->\n" +
            "    <target name=\"deploy\">\n" +
            "      <!-- Upload the contents of the \"retrievedSource\" directory-->\n" +
            "      <sf:deploy username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\"\n" +
            "	 maxPoll=\"${sf.maxPoll}\" deployRoot=\"retreivedSource\" rollbackOnError=\"true\">\n" +
            "      </sf:deploy>\n" +
            "    </target>\n" +
            "	\n" +
            "\n" +
            "	<!-- Shows deploying code and running tests only within the org namespace -->\n" +
            "	<target name=\"deployCodeRunLocalTests\">\n" +
            "	  <sf:deploy username=\"${sf.username}\" password=\"${sf.password}\" sessionId=\"${sf.sessionId}\" serverurl=\"${sf.serverurl}\"\n" +
            "	  maxPoll=\"${sf.maxPoll}\" checkOnly=\"true\" deployRoot=\"retreivedSource\" rollbackOnError=\"true\"  testlevel=\"RunLocalTests\"/>\n" +
            "	</target>\n" +
            "	\n" +
            "   \n" +
            "\n" +
            "\n" +
            "</project>";
    
}

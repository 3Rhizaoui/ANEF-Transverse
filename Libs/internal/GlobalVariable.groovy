package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URLpwQualif
     
    /**
     * <p></p>
     */
    public static Object Token
     
    /**
     * <p></p>
     */
    public static Object NumEtrangerVisa
     
    /**
     * <p></p>
     */
    public static Object Password
     
    /**
     * <p></p>
     */
    public static Object DateDebut
     
    /**
     * <p></p>
     */
    public static Object DateFin
     
    /**
     * <p></p>
     */
    public static Object URLPortailAgentQualif
     
    /**
     * <p></p>
     */
    public static Object IdentifiantAgentQualif
     
    /**
     * <p></p>
     */
    public static Object PwAgentQualif
     
    /**
     * <p></p>
     */
    public static Object URL_ANEFQualif
     
    /**
     * <p></p>
     */
    public static Object NumEphoto
     
    /**
     * <p></p>
     */
    public static Object TypeTitreDeSejour
     
    /**
     * <p></p>
     */
    public static Object NumeroTelephoneUsager
     
    /**
     * <p></p>
     */
    public static Object downloadPath
     
    /**
     * <p></p>
     */
    public static Object AdresseUsager
     
    /**
     * <p></p>
     */
    public static Object NumEtrangerVisaInPDF
     
    /**
     * <p></p>
     */
    public static Object PourQui
     
    /**
     * <p></p>
     */
    public static Object Titre
     
    /**
     * <p></p>
     */
    public static Object StopTestCase
     
    /**
     * <p></p>
     */
    public static Object MsgStopTestCase
     
    /**
     * <p></p>
     */
    public static Object medium_wait
     
    /**
     * <p></p>
     */
    public static Object DriverName
     
    /**
     * <p></p>
     */
    public static Object URL_ANEFPreProd
     
    /**
     * <p></p>
     */
    public static Object URLpwPreProd
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            URLpwQualif = selectedVariables['URLpwQualif']
            Token = selectedVariables['Token']
            NumEtrangerVisa = selectedVariables['NumEtrangerVisa']
            Password = selectedVariables['Password']
            DateDebut = selectedVariables['DateDebut']
            DateFin = selectedVariables['DateFin']
            URLPortailAgentQualif = selectedVariables['URLPortailAgentQualif']
            IdentifiantAgentQualif = selectedVariables['IdentifiantAgentQualif']
            PwAgentQualif = selectedVariables['PwAgentQualif']
            URL_ANEFQualif = selectedVariables['URL_ANEFQualif']
            NumEphoto = selectedVariables['NumEphoto']
            TypeTitreDeSejour = selectedVariables['TypeTitreDeSejour']
            NumeroTelephoneUsager = selectedVariables['NumeroTelephoneUsager']
            downloadPath = selectedVariables['downloadPath']
            AdresseUsager = selectedVariables['AdresseUsager']
            NumEtrangerVisaInPDF = selectedVariables['NumEtrangerVisaInPDF']
            PourQui = selectedVariables['PourQui']
            Titre = selectedVariables['Titre']
            StopTestCase = selectedVariables['StopTestCase']
            MsgStopTestCase = selectedVariables['MsgStopTestCase']
            medium_wait = selectedVariables['medium_wait']
            DriverName = selectedVariables['DriverName']
            URL_ANEFPreProd = selectedVariables['URL_ANEFPreProd']
            URLpwPreProd = selectedVariables['URLpwPreProd']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}

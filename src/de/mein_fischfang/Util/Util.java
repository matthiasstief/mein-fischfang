package de.mein_fischfang.Util;

/**
 * <b>Title:</b> Util <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public final class Util
{
    /**
     * Konstruktor
     */
    private Util()
    {

    }

    /**
     * nn
     *
     * Die Methode prüft ob der String NULL ist. Ist der String NULL wird ein Leerstring zurückgegeben, ansonsten der Orginalstring
     *
     * @param s String
     * @return String
     */
    public static String nn(String s)
    {
        if (s == null)
        {
            return "";
        }
        else
        {
            return s;
        }
    }

    /**
     * isInteger
     *
     * Die Methode prüft ob der String einen Integerwert entspricht
     *
     * @param s String
     * @return boolean
     */
    public static boolean isInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * isBoolean
     *
     * Die Methode prüft ob der String einen Doublewert entspricht
     *
     * @param s String
     * @return boolean
     */
    public static boolean isBoolean(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}

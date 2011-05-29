package org.jaxws.stub2html.view.simple;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.jaxws.stub2html.view.JavaNameDisplayStrategy;

/**
 * 
 * @author chenjianjx
 * 
 */
public class SimpleJavaNameDisplayStrategy extends JavaNameDisplayStrategy {

    private static final Map<Class<?>, String> PRIMITIVE_TYPE_DISPLAY = new HashMap<Class<?>, String>();
    static {
        PRIMITIVE_TYPE_DISPLAY.put(String.class, "String");

        PRIMITIVE_TYPE_DISPLAY.put(BigDecimal.class, "BigDecimal");
        PRIMITIVE_TYPE_DISPLAY.put(BigInteger.class, "BigInteger");
        PRIMITIVE_TYPE_DISPLAY.put(Byte.class, "Byte");
        PRIMITIVE_TYPE_DISPLAY.put(Double.class, "Double");
        PRIMITIVE_TYPE_DISPLAY.put(Float.class, "Float");
        PRIMITIVE_TYPE_DISPLAY.put(Integer.class, "Integer");
        PRIMITIVE_TYPE_DISPLAY.put(Long.class, "Long");
        PRIMITIVE_TYPE_DISPLAY.put(Short.class, "Short");

        PRIMITIVE_TYPE_DISPLAY.put(int.class, "Int");
        PRIMITIVE_TYPE_DISPLAY.put(float.class, "Float");
        PRIMITIVE_TYPE_DISPLAY.put(double.class, "Double");
        PRIMITIVE_TYPE_DISPLAY.put(byte.class, "Byte");
        PRIMITIVE_TYPE_DISPLAY.put(char.class, "Char");
        PRIMITIVE_TYPE_DISPLAY.put(Boolean.class, "Boolean");
        PRIMITIVE_TYPE_DISPLAY.put(boolean.class, "Boolean");
        PRIMITIVE_TYPE_DISPLAY.put(Date.class, "Date");
        PRIMITIVE_TYPE_DISPLAY.put(Calendar.class, "Calendar");
        PRIMITIVE_TYPE_DISPLAY.put(XMLGregorianCalendar.class, "Calendar");

    }

    /**
     * order-id => Order Id
     */
    public String displayElementName(String elementName) {
        String[] words = StringUtils.split(elementName, "-");
        List<String> capitalized = new ArrayList<String>();
        for (String word : words) {
            capitalized.add(StringUtils.capitalize(word));
        }
        return StringUtils.join(capitalized, " ");
    }

    public String displayClassName(Class<?> clazz) {
        String className = clazz.getSimpleName();
        return SimpleClassNameDisplayUtils.display(className);
    }

    public String displayElementType(Class<?> type) {
        String display = PRIMITIVE_TYPE_DISPLAY.get(type);
        if (display != null) {
            return display;
        }
        if (type.isEnum()) {
            return Arrays.asList(type.getEnumConstants()).toString();
        }
        return null;
    }

}

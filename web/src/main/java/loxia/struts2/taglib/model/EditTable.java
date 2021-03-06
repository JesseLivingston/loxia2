package loxia.struts2.taglib.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loxia.struts2.taglib.annotation.LoxiaSkipTag;

import com.opensymphony.xwork2.util.ValueStack;

@LoxiaSkipTag(name="edittable", tldTagClass="loxia.struts2.taglib.tag.EditTableTag", description="Render an HTML Table element")
public class EditTable extends Table {
	
	/**
     * The name of the default template for the Loxia TableTag
     */
	final public static String OPEN_TEMPLATE = "loxia_edittable";
    
	public EditTable(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }
    
	@Override
	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}
}

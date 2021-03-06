package loxia.struts2.taglib.tag;

import org.apache.struts2.views.jsp.ui.AbstractUITag;

import loxia.struts2.taglib.model.LoxiaUIBean;

public abstract class LoxiaAbstractUITag extends AbstractUITag {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8390139354460753843L;
	
	protected String htmlAttr;
    
	@Override
    protected void populateParams() {
        super.populateParams();

        LoxiaUIBean uiBean = (LoxiaUIBean) component;
        uiBean.setHtmlAttr(htmlAttr);
    }

	public void setHtmlAttr(String htmlAttr) {
		this.htmlAttr = htmlAttr;
	}

}

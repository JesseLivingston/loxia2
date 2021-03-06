<#setting number_format="#"/>
<input loxiaType="dropdown"<#rt/>
 name="${parameters.name?default("")?html}"<#rt/>
 <#if parameters.get("size")?exists>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength?exists>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameValue?exists>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.editable?default(false)>
 editable="true"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.required?default(true)>
 required="true"<#rt/>
</#if>
<#if parameters.checkmaster?exists>
 checkmaster="${parameters.checkmaster?html}"<#rt/>
</#if>
<#if parameters.choice?exists>
 ${parameters.choice?html}<#rt/>
</#if>
<#if parameters.findMode?exists>
 ${parameters.findMode?html}<#rt/>
</#if>
<#if parameters.htmlAttr?exists>
 ${parameters.htmlAttr?html}<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id?exists>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/>
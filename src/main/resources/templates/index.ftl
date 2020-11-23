<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>

<@c.page>



<h1>Welcome</h1>
<#if message??>
    <h2>${message}</h2>
</#if>

<a href="<@spring.url '/userList'/>">User List</a>


</@c.page>
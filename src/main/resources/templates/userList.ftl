<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>

<@c.page>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone number</th>
            <th>Company</th>
        </tr>
        <#list users as user>
            <#list user.phoneNumbers as phone>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.lastName}</td>
                    <td>${phone.number}</td>
                    <td>${phone.company.name}</td>
                </tr>
            </#list>
        </#list>
    </table>
</@c.page>
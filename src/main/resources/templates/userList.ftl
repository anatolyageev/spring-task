<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>

<@c.page>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone number</th>
        </tr>
        <#list users as user>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.lastName}</td>
                    <td>
                        <#list user.phoneNumbers as phone>
                        ${phone.company.name} - ${phone.number};
                        </#list>
                    </td>
                </tr>
        </#list>
    </table>
</@c.page>
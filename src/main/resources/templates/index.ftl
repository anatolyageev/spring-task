<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>


<@c.page>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1>Welcome</h1>
                <#if message??>
                    <h2>${message}</h2>
                </#if>
            </div>
        </div>
    </div>

</@c.page>
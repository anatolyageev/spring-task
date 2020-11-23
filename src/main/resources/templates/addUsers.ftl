<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">
<div class="col-md-8 col-md-offset-2">
<h3>File Input</h3>
<form method="POST" action="/uploadFile" enctype="multipart/form-data">
    <div class="form-group">
        <div class="input-group input-file" name="Fichier1">
            <input type="file" name="file" class="form-control" placeholder='Choose a file...' />
        </div>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary pull-right" >Submit</button>
    </div>

    <#if message??>
        <h2>${message}</h2>
    </#if>
</form>
</@c.page>


<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>

<@c.page>

    <h1>Log in</h1>

    <p>For test can be used login/password: demo / demo</p>

    <form role="form" action="/login" method="post">

        <div>
            <label for="username">User name</label>
            <input type="text" name="username" id="username" required autofocus/>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required/>
        </div>
        <div>
            <label for="remember-me">Remember me</label>
            <input type="checkbox" name="remember-me" id="remember-me"/>
        </div>
        <button type="submit">Sign in</button>
    </form>
</@c.page>
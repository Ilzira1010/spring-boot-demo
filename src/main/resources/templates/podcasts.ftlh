<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>Profile</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand mb-0 h1" href="/main">Podcaster</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/profile">My profile</a>
                </li>
            </ul>

            <#if !user??>
                <button class="btn btn-primary my-2 my-sm-0" onclick="location.href='/signIn'">Sign In</button>
                <button class="btn btn-primary my-2 my-sm-0 ml-3 mr-3" onclick="location.href='/signUp'">Sign Up</button>
            </#if>
            <button class="btn btn-primary my-2 my-sm-0" onclick="location.href='/podcasts'">Search</button>

        </div>
    </nav>
</header>
<main>
    <div class="container">
        <form action="/podcasts" method="get" id='search_form' class="form-inline my-2 w-100">
            <input name="search" class="form-control mr-sm-2 ml-3 w-75" id='inputSearch' type="search" placeholder="Search"
                   aria-label="Search">
            <select class="form-control mx-3" name="category">
                <option value="0" selected>---</option>

                <#list categories as c>
                    <option value="${c.getId()}">${c.getName()}</option>
                </#list>
            </select>
            <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>

        </form>
    </div>
    <div id="results">

    </div>


<footer class="footer navbar-fixed-bottom font-small pt-4">
    <hr>
    <div class="container">
        <ul class="list-unstyled list-inline text-center">
            <li class="list-inline-item">
                <a class="btn-floating btn-fb mx-1 text-dark" href="https://vk.com/i.akhmetdinova" target="_blank">
                    <i class="fab fa-vk"> </i>
                </a>
            </li>
            <li class="list-inline-item">
                <a class="btn-floating btn-tw mx-1 text-dark" href="http://instagram.com/a.ilzira_1010" target="_blank">
                    <i class="fab fa-instagram"> </i>
                </a>
            </li>
            <li class="list-inline-item">
                <a class="btn-floating btn-li mx-1 text-dark" href="https://t.me/IlziraAkhmetdinova" target="_blank">
                    <i class="fab fa-telegram"> </i>
                </a>
            </li>
        </ul>
    </div>
    <div class="footer-copyright text-center py-3">© 2020 Copyright:
        <a>Ilzira Akhmetdinova</a>
    </div>
</footer>
<script src="/js/fontawesome.js"></script>
<script src="/js/jquery-3.5.1.min.js"></script>
<script src="/js/bootstrap.bundle.js"></script>
<script src="/js/search.js"></script>

</body>
</html>


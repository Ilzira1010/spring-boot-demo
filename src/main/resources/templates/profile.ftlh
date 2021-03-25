<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <title>Main</title>
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
<#--            <#if test="${user == null}">-->
<#--                <button class="btn btn-primary my-2 my-sm-0" onclick="location.href='/signIn'">Sign In</button>-->
<#--                <button class="btn btn-primary my-2 my-sm-0 ml-3 mr-3" onclick="location.href='/signUp'">Sign Up</button>-->
<#--            </#if>-->
            <button class="btn btn-primary my-2 my-sm-0" onclick="location.href='/podcasts'">Search</button>
        </div>
    </nav>
</header>
<main>
    <button class="btn btn-primary m-3" onclick="location.href='/create'">Create Podcast</button>
    <button class="btn btn-primary m-3" onclick="location.href='/quit'">Sign Out</button>
    <div class="container">
        <h2 class="text-center">My Podcasts</h2>
        <#list podcasts as p>
            <div class="card container m-3">
                <div class="row">
<#--                    <div class="col-lg-3 p-0">-->
<#--                        <img class="card-img-top img-fluid" src="/img?name=${p.getImg()}" alt="Image of podcast">-->
<#--                    </div>-->
                    <div class="col-lg-9">
                        <div class="card-body">
                            <h2 class="card-text podcast-title title">${p.getTitle()}</h2>
                            <h3 class="card-text podcast-title category">Category: <span>${p.getCategory().getName()}</span></h3>
                        </div>
                        <div class="card-body">
<#--                            <p class="card-text">${p.getUser().getNickname()} / ${p.getCreated_at()}</p>-->
                            <div class="container-audio">
<#--                                <audio controls preload="auto" id="audio">-->
<#--                                    <source src="/track?name=${p.getTrack()}" type="audio/ogg">-->
<#--                                    Your browser dose not Support the audio Tag-->
<#--                                </audio>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="button-container mb-2 w-50 ml-2">
                <a class="btn btn-success mx-2 w-25" href='/edit?id=${p.getId()}'>Edit</a>
                <a class="btn btn-danger mx-2 w-25" href='/delete?id=${p.getId()}'>Delete</a>
            </div>
        </#list>
    </div>
</main>
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
</body>
</html>



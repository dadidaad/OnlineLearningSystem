<%-- 
    Document   : Home
    Created on : Jan 16, 2022, 10:27:18 PM
    Author     : Hoang ngoc Long
--%>

<%@page import="bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="i" uri="/WEB-INF/tlds/customTag"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
          <!-- Link to bootstrap fontawesome and Boxicon -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/7ca0ffd650.js" crossorigin="anonymous"></script>
        <!-- Link to css file -->
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/style.css"/>">
        <link rel="stylesheet" href="<i:ReadUrlFromContext url="/assets/css/StarRating.css"/>"/>
        <title>Home page</title>
    </head>
    <body>
        <!-- Include header of web site from general-->
        <div  class="container">
            <jsp:include page="./header.jsp"></jsp:include>
            </div>

            <!--All home section-->
            <div class="allhome">
                <section class="home" id="home">
                    <div class="content">
                        <h3>Welcome to TutorDuo</h3>
                        <p>
                            The core content of the subject helps students to form and develop their communication ability through practicing listening, speaking, reading and writing skills.</p>
                        <a href="<i:ReadUrlFromContext url="/listarticle"/>" class="btn">More information</a>
                    </div>
                    <div class="image">
                        <img src="<i:ReadUrlFromContext url="/assets/image/background-title.png"/>"
                </div>
            </section>

            <!--section about us-->
            <section class="about" id="about">

                <div class="container">

                    <div class="row align-items-center">
                        <div class="col-md-6">
                            <img  src="<i:ReadUrlFromContext url="/assets/image/why.jpg"/>" class="w-100" style="width: 50%;margin-top: 40px" alt="">

                        </div>
                        <div class="col-md-6">
                            <h3 class="title">Tutor duo</h3>
                            <p>why do you choose this website </p>
                            <div class="icons-container">
                                <div class="icons">
                                    <i class="fas fa-book-open"></i>
                                    <h3>Approaching to the lessons</h3>
                                </div>
                                <div class="icons">
                                    <i class="fas fa-chalkboard-teacher"></i>
                                    <h3>Hire the suitable teacher</h3>
                                </div>
                                <div class="icons">
                                    <i class="fas fa-school"></i>
                                    <h3>The high quality of subject</h3>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </section>

            <!-- end section about us-->

            <!--section the famous teacher-->


            <section class="review" id="review">

                <h1 class="heading"> THE TOP <span> TEACHER</span> </h1>

                <div class="box-container">
                    <c:forEach items="${requestScope.teachers}" var ="t" varStatus="loop">   
                        <div class="box">
                            <img src="<i:ReadUrlFromContext url="${t.getAvatar()}"/>"  alt="">
                            <h3>${t.getDisplayName()}</h3>
                            <div id="rating">
                                <input type="radio" id="star5${loop.index+1}" name="rating${loop.index+1}" value="5" disabled/>
                                <label class="full" for="star5${loop.index+1}" title="Awesome - 5 stars"></label>

                                <input type="radio" id="star4half${loop.index+1}" name="rating${loop.index+1}" value="4 and a half" disabled/>
                                <label class="half" for="star4half${loop.index+1}" title="Pretty good - 4.5 stars"></label>

                                <input type="radio" id="star4${loop.index+1}" name="rating${loop.index+1}" value="4" disabled/>
                                <label class="full" for="star4${loop.index+1}" title="Pretty good - 4 stars"></label>

                                <input type="radio" id="star3half${loop.index+1}" name="rating${loop.index+1}" value="3 and a half" disabled/>
                                <label class="half" for="star3half${loop.index+1}" title="Meh - 3.5 stars"></label>

                                <input type="radio" id="star3${loop.index+1}" name="rating${loop.index+1}" value="3" disabled/>
                                <label class="full" for="star3${loop.index+1}" title="Meh - 3 stars"></label>

                                <input type="radio" id="star2half${loop.index+1}" name="rating${loop.index+1}" value="2 and a half" disabled/>
                                <label class="half" for="star2half${loop.index+1}" title="Kinda bad - 2.5 stars"></label>

                                <input type="radio" id="star2${loop.index+1}" name="rating${loop.index+1}" value="2" disabled/>
                                <label class="full" for="star2${loop.index+1}" title="Kinda bad - 2 stars"></label>

                                <input type="radio" id="star1half${loop.index+1}" name="rating${loop.index+1}" value="1 and a half" disabled/>
                                <label class="half" for="star1half${loop.index+1}" title="Meh - 1.5 stars"></label>

                                <input type="radio" id="star1${loop.index+1}" name="rating${loop.index+1}" value="1" disabled/>
                                <label class="full" for="star1${loop.index+1}" title="Sucks big time - 1 star"></label>

                                <input type="radio" id="starhalf${loop.index+1}" name="rating${loop.index+1}" value="half" disabled/>
                                <label class="half" for="starhalf${loop.index+1}" title="Sucks big time - 0.5 stars"></label>
                            </div>
                            <br>
                            <p style="font-size:14px;font-style: italic;">${t.getDescription()}</p>
                        </div>
                    </c:forEach> 
                </div>
                <a href="ListAllTeacher" class="More">Show More</a>
            </section>
            <section class="speciality" id="speciality">

                <!--end section the famous teacher-->              

                <!--section subject-->
                <h1 class="heading"> <span>Subject</span> </h1>

                <div class="box-container">

                    <div class="box">
                        <div class="content">
                            <img src="<i:ReadUrlFromContext url="/assets/image/Mathsicon.png"/>" alt="">
                            <h3>Maths</h3>
                            <p>Mathematics  the science of structure, order, and relation that has evolved from elemental practices of counting, measuring, and describing the shapes of objects.</p>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content">
                            <img src="<i:ReadUrlFromContext url="/assets/image/physic.png"/>" alt="">
                            <h3>Physic</h3>
                            <p>Physics(natural science) is the natural science that studies matter, its fundamental constituents, its motion and behavior through space and time, and the related entities </p>
                        </div>
                    </div>
                    <div class="box">
                        <div class="content">
                            <img src="<i:ReadUrlFromContext url="/assets/image/chemistry.png"/>" alt="">
                            <h3>Chemistry</h3>
                            <p>Chemistry is the study of matter and the chemical reactions between substances. Chemistry is also the study of matter's composition, structure, and properties</p>
                        </div>
                    </div>
                </div>
            </section>
            <!-- end section subject-->

        </div>
        <!--end of home section-->
        <!-- Include footer of web site from general-->
        <div class="container">
            <jsp:include page="./footer.jsp"></jsp:include>
        </div>
        <script>
            <c:forEach items="${requestScope.teachers}" var ="t" varStatus="loop">
            window.document.onload = calcRate(${t.getReputation()}, ${loop.index+1});
            </c:forEach>

            function calcRate(r, num) {
                const f = ~~r, // = Math.floor(r)
                        id = "star" + f + (r % f ? "half" + num : "" + num);
                id && (document.getElementById(id).checked = !0);
            }
        </script>
    </body>
</html>

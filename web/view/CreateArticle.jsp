<%-- 
    Document   : Creator
    Created on : Oct 14, 2020, 4:11:57 PM
    Author     : Long
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creator</title>
              <!-- Link to bootstrap fontawesome and Boxicon -->
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container">
            
            <!--begin of form-->
            
            <form class="col-sm-12" action="/OnlineLearningSystem/createarticle" method="post" name="myForm">
                <h2>Create new article</h2>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Link image</label>
                    <input name="image" type="text" class="form-control" id="exampleFormControlInput1" placeholder="https://genk.mediacdn.vn/thumb_w/660/139269124445442048/2020/10/14/jxcvj-16026312062441713789234.jpg">
                </div>
                <label for="image"><span style="color: red;" id="errorImage"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Tittle</label>
                    <textarea name="title" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                <label for="image"><span style="color: red;" id="errorTitle"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Description</label>
                    <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
                </div>
                 <label for="image"><span style="color: red;" id="errordes"></span></label> 
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">CreateName</label>
                    <textarea name="createname" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                  <label for="image"><span style="color: red;" id="errorName"></span></label> 
                <button  onClick="return FormValidate();" type="submit" class="btn btn-primary">Create</button>
            </form>
            
            <!--end of form-->
           
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
     <script type="text/javascript">
            function FormValidate() {
               var image = document.myForm.image.value.trim();
                var errorImage = document.getElementById('errorImage');
                 var errorTitle = document.getElementById('errorTitle');
                  var errordes = document.getElementById('errordes');
                   var errorName = document.getElementById('errorName');
               if(image==""||image==null){
                   errorImage.innerHTML = "Please enter image";
                   return false;
               }
                var title = document.myForm.title.value.trim();
                if(title==""||title==null){
                   errorTitle.innerHTML = "Please enter title";
                   return false;
               }
               var description = document.myForm.description.value.trim();
                if(description==""||description==null){
                   errordes.innerHTML = "Please enter description";
                   return false;
               }
                var createname = document.myForm.createname.value.trim();
                if(createname==""||createname==null){
                   errorName.innerHTML = "Please enter create name";
                   return false;
               }
            }

        </script>
    </body>
</html>

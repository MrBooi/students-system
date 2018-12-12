let app = new Vue ({
	
   el: '#app', 

   data: {
       showAvgScore :false,
       showAdd: false,
       ShowEditProfile :false,
       showDashboard :true,
        studentList :[],
       student: {
    	   name:'',
    	   surname:'',
    	   age:'',
    	   email:'',
    	   score : '',
       }, 
       prevScore:0,
       msg :'',
       success : null
       
   },
   
   computed :{ 
	  
	   alertMessage : function(){
	        let self = this;
	          if(self.success){
	       	  return "alert alert-primary";
	          } 
	          else if(self.success === false){
	        	  return "alert alert-danger";
	          }
	   	}
	   
    
   },
   
   
   
   components : {
	   'student-list' : StudentList,
	   'edit-student' : EditStudent
   },
 
   methods : {
    dashBoard: function () {
        this.showDashboard =true;
        this.showAvgScore = false;
        this.ShowEditProfile = false;
    },
    averageScore : function () {
        this.showDashboard =true;
        this.showAvgScore = true;
        this.ShowEditProfile = false; 
    },
    clickedOnStudent : function(params){
    	this.studentId = params.student_id;
    	this.editProfile();
    },
    editProfile : function () {
        this.showDashboard =false;
        this.showAvgScore = false;
        this.ShowEditProfile = true; 
    } ,

addStudent: function () {
	   let self = this;
  let studentData = this.student; 
 
  axios.post('/api/add/new/student',studentData)
  .then((results) => {
  	 const {success,message} = results.data;
      if (success) {         
         this.success =success;
         this.msg=message;
         
      }
      else{
    	  this.success =success;
          this.msg=message;
      }
  });
},
capture_Score : function () {
	  let self = this;
	 axios.post('/api/capture/student/score',self.student)
	 .then((result) => {
		  const {message,success}= result.data 
		  console.log(message,success);
		  if(success){
	      console.log(message);
	      this.success =success;
	         this.msg=message;
		  } 
		  else{
			   this.success =success;
		         this.msg=message;
		  }
		  
	 })
},

	clear : function(){
        let self = this;
        this.success ='';
        this.msg='';
        self.student= {
				 name : '',
				 surname:'',
				 age    :'',
				 email  :''
		 }

   	}


   
   }
})
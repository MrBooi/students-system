let app = new Vue ({
	
   el: '#app', 

   data: {
       showAvgScore :false,
       showAdd: false,
       ShowEditProfile :false,
       showDashboard :true,
        studentList :[],
       student: {
    	   name:'Aya',
    	   surname:'',
    	   age:'',
    	   email:'',
    	   score :'50'
       }, 
       prevScore:0,
       msg :'',
       isError : false
       
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
  	console.log("data",results);
      if (results.success) {         
         self.msg = results.msg
         
      }
      else{
      	  self.isError =true;
      	  self.msg =results.msg
        
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
		  } 
		  
	 })
}


   
   }
})
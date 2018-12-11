var EditStudent = Vue.component('edit-student',{
    
	props : ["studentId"],
	
    data: function(){
        return{
       studentData:{ 
    	  name:'',
          surname:'',
          age:0,
          email :''}
        
        }
    },
   
    mounted : function() {
        let self = this;
        axios.get('/api/find/by/student/id/'+this.studentId)
        .then((results) => {
           const {data,success} = results.data;
        	if(success){
        	self.studentData = data;
        	}
        	else{
        		console.log("opps something is wrong");
        	}
        });
          
    },
    methods : {
    	
    	editProfile : function(){
    		let self = this; 
    		 axios.post('/api/edit/student',self.studentData)
    		  .then((results) => {
    			
    		  	const {success,message} = results.data;
    		  	
    		      if (success) {         
    		       console.log(message);
    		      }
    		  });
    	},
    	
    	deleteProfile : function(){
    		let self = this; 
   		 axios.get('/api/remove/student/id/'+self.studentId)
   		  .then((results) => {
   		  	const {success,message} = results.data;
   		  	
   		      if (success) {         
   		      self.studentData = [];
   		      }
   		  });
    	}
    },
    template : `
    <div> 
         <section id="profile">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header">
                  <h4>Edit Profile</h4>
                </div>
                <div class="card-body">
                  <form>
                    <div class="form-group">
                      <label for="name">Name</label>
                      <input type="text"   v-model="studentData.name" disabled  class="form-control" value="">
                    </div>
                    <div class="form-group">
                        <label for="Surname">Surname</label>
                        <input type="text" v-model="studentData.surname" class="form-control" value="">
                      </div>
                      <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" v-model="studentData.age"  class="form-control" value="">
                      </div>
                    <div class="form-group">
                      <label for="email">Email</label>
                      <input type="text" v-model="studentData.email" class="form-control" value="">
                    </div>
                  </form>
                  <div class="col-md-3 float-right ">
                    <button class="btn btn-primary btn-block" v-on:click="editProfile()">Edit Student</button>
                  </div>
                  <div class="col-md-3 ">
                    <button class="btn btn-danger btn-block float-right" v-on:click="deleteProfile()"   >Delete Account</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    
    
    
    </div>
    `
 


})

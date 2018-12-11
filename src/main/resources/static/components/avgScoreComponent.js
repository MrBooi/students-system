Vue.component('avg-score',{

    data: function(){
        return{
           averageScore:0.00
        }
    },
    mounted : function() {
        let self = this;
        axios.get("/api/students/score/average")
    	.then((response) => {
    	  const {success,data} = response.data;
    	  if(success){
    		  self.averageScore = data[0].toFixed(2);
    	  }
    	})
    },
    methods : {
    	  capture_Score : function () {
        	  let self = this;
        	 axios.get('/api/find/by/name/Thabiso')
        	 .then((result) => {
        		 let data = result.data.data;
        		 const {id} = data;
        		 const {score} = self.student;
        		  if(result.data.success){
        	
        			  axios.post('/api/add/student/id/id/score/score')
        			    .then((results) => {
        			    	console.log("data",results.data);
        			        if (results.data.success) {         
        			         
        			         console.log("happy")
        			        }
        			        else{
        			        	  self.isError =true;
        			        	  self.msg =results.msg
        			          
        			        }
        			    });
        		  } 
        		  else{
        			  console.log('user name is not found');
        		  }
        	 })
         }
    },
    template : `
    <div> 
    <section id="score" class="mb-2">
    <div class="container">
    <div class="row">
      <div class="col-md-6">
        <div>
          <h4 class="text-primary" >Student's Average Score is: <span>{{averageScore}}</span></h4>
        </div>
      </div>
    </div>
    </div>
 </section>
    </div>
    `
})

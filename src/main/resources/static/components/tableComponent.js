var StudentList = Vue.component('student-list',{
    data: function(){
        return{
        	studentList :[],
        	student_id :'',
        }
    },
    mounted : function() {
        let self = this; 
        axios.get('/api/get/all/students')
        .then((results) => {
            const {data} = results;
            for(const current of data){
         	   self.studentList.push(current);
            }
        });
    },
    methods : {
      editProfile : function(userId){ 
             //console.log(userId)
      this.student_id =userId; 
      this.$emit('clicked-on', { 'student_id': this.student_id});
      },
    },
    template : `
    <div> 
   
    <section id="students mt-2">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-header">
              <h4>Student Score Place</h4>
            </div>
            <table class="table table-striped">
              <thead class="thead-inverse">
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Surname</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="student in studentList">
                  <td scope="row">*</td>
                  <td>{{student.name}}</td>
                  <td>{{student.surname}}</td>
                  <td><button class="btn btn-secondary" v-on:click='editProfile(student.id)'>
                    <i class="fa fa-angle-double-right"></i> Edit/View score
                  </button></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </section>
    
    
    
    
    </div>
    `
 


})

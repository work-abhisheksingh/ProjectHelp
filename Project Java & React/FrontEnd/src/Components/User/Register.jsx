import {  useState } from "react";


import userservice from "../Services/userservice";
import { useHistory } from "react-router-dom";

function Register() {

    let history = useHistory();

  
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    async function save(event) {
        event.preventDefault();

        const user ={ name,email , password};

        const selectedOption=document.querySelector("#users");
        const output=selectedOption.value;

        if(output === "Admin")
        {
          await userservice.adduser(user).then((response)=> {
            console.log(response.data)
                localStorage.setItem("admin",JSON.stringify(response.data))
            
            history.push("/food/viewallfood");
            
        }).catch((error) => {
            console.log(error.response.data)
        })
          alert("User Registation Successfully");

        
      }
      else if (output==="Customer")
      {
        await userservice.adduser(user).then((response)=> {
            console.log(response.data)
                localStorage.setItem("customer",JSON.stringify(response.data))
            
            history.push("/food/viewallfood");
            
        }).catch((error) => {
            console.log(error.response.data)
        })
          alert("User Registation Successfully");

      }
    }
  
    return (
    <div>
    <div class="container mt-4" >
    <div class="card">
            <h1>User Registation</h1>
    
    <form>
        <div class="form-group">
          <label>User name</label>
          <input type="text"  class="form-control" id="name" placeholder="Enter Name"
          
          value={name}
          onChange={(event) => {
            setName(event.target.value);
          }}
          />

        </div>

        <div class="form-group">
          <label>email</label>
          <input type="email"  class="form-control" id="email" placeholder="Enter Email"
          
          value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          
          />
 
        </div>

        <div class="form-group">
            <label>password</label>
            <input type="password"  class="form-control" id="password" placeholder="Enter password"
            
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            
            />
          </div>

          <select id='users'>
                <option value="Admin">Admin</option>
                <option value="Customer">Customer</option>
                <option value="Vendor">Vendor</option>
                <option value="DeliveryBoy">DeliveryBoy</option>
            </select>

        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>
       
      </form>
    </div>
    </div>
     </div>
    );
  }
  
  export default Register;
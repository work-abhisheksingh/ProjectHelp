
import { useState } from "react";
import { useHistory } from "react-router-dom";
import userservice from "../Services/userservice";


const Login = () =>{

  let history = useHistory();


    const[email,setEmail]=useState('');
    const[password,setPassword]=useState('');



    const handleApi = (e) =>{
        //console.log(email , pwd);

        e.preventDefault();

        const user ={email,password}

        const selectedOption=document.querySelector("#users");
        const output=selectedOption.value;

        //alert(output);
        if(output === "Admin")
        {
          userservice.signin(user)
          .then((response)=>{
          //console.log(response.data);
          // alert("success")
          if(localStorage.getItem("admin")!== null)
          {

           // alert(localStorage.getItem("admin"))
          history.push("/")
        }}).catch(error=>{
            alert("Invalid credentials")
            console.log(error)})

          }
          else if (output==="Customer")
          {
            userservice.signin(user)
          .then((response)=>{
          //console.log(response.data),
          // alert("success")
          if(localStorage.getItem("customer") !== null)
          {
             history.push('/food/viewallfood')
          }})
          .catch(error=>{
            alert("Invalid credentials")
            console.log(error)})
          }

    }


    return(
        <div className="container" >
            <form>
  <div class="mb-3">
    <label for="email" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" 
    onChange={ e => setEmail(e.target.value)}/>
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>

  <div class="mb-3">
    <label for="pwd" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1"
    onChange={ e => setPassword(e.target.value)}/>
  </div>

  <select id='users'>
                <option value="Admin">Admin</option>
                <option value="Customer">Customer</option>
                <option value="Vendor">Vendor</option>
                <option value="DeliveryBoy">DeliveryBoy</option>
            </select>

  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button onClick={handleApi} class="btn btn-success">Login</button>
</form>
        </div>
    )
}

export default Login
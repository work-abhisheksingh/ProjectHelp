
import React, { useEffect, useState } from "react";
import { Link, useHistory, useParams } from "react-router-dom";

import foodservice from '../Services/foodservice'

const AddFood =() =>{

    let history = useHistory();


    const[name,setname] = useState('');
    const[description,setdescription] = useState('');
    const[price,setprice] = useState('');
    const[categoryId,setcategoryId] = useState('');
    const[categoryName,setcategoryName] = useState('');

    const{foodId} = useParams();


    // const handlesubmit = async e => {
    //     e.preventDefault();

    //     const foodcategory= {
    //       categoryId : categoryId,
    //       categoryName : categoryName
    //     }

    //     const foodData={
    //         name:name,
    //         description:description,
    //         price:price,
    //         foodcategory 
    //     };


    //     console.log(foodData);

    //     await foodservice.addFood(foodData)
    

    //         history.push("/viewallfood");  //redirect after action
    //     };

        useEffect (() => {
            foodservice.getFoodById(foodId).then((response) => {
              setname(response.data.name)
              setdescription(response.data.description)
              setprice(response.data.price)
              setcategoryId(response.data.categoryId)
              setcategoryName(response.data.categoryName)
            }).catch(error => {
              console.log(error)
            })
        },[]);

       
    
        const addOrUpdateFood = async (e) => {
          e.preventDefault();

          const foodcategory = {categoryId , categoryName}
          const food = {name , description , price , foodcategory}

          if (foodId){
              await  foodservice.updateFood(foodId , food)
              .then((response)=> {
                console.log(response.data)
                history.push("/food/viewallfood");
                
            }).catch((error) => {
                console.log(error.response.data)
            })
          }else{
            await  foodservice.addFood(food)
            .then((response)=> {
              console.log(response.data)
              history.push("/food/viewallfood");
              
          }).catch((error) => {
              console.log(error.response.data)
          })
          }

          history.push("/")
        
      }

      const title = ()=> {
        if(foodId){
          return <h2  className="text-center"> Update Food</h2>
        }else{
          return <h2  className="text-center" > Add Food</h2>
        }
      }
    
      
      
    return(
        <div align='container'>
          <div className="row">
          <div className="card col -md-6 offset-md-3 offset-md-3">
            {
              title()
            }
            <div className="card-body">
        <form >
          <div className="form-group mb-2" >
            <label className="form-label">Enter Food Name</label>
            <input 
                 type="text" 
                 className="form-control" 
                 name="name" 
                 value={name} 
                 onChange={ (e) => setname(e.target.value)} />
        </div>
        <div className="form-group mb-2 " >
            <label className="form-label">Enter Food Description</label>
            <input 
                 type="text" 
                 className="form-control " 
                 name="description" 
                 value={description} 
                 onChange={ (e) => setdescription(e.target.value)} />
        </div>
        <div className="form-group mb-2" >
            <label className="form-label">Enter Food Price</label>
            <input 
                 type="text" 
                 className="form-control" 
                 name="price" 
                 value={price} 
                 onChange={ (e) => setprice(e.target.value)} />
        </div>
        <div className="form-group mb-2" >
            <label className="form-label">Enter Category ID</label>
            <input 
                 type="text" 
                 className="form-control" 
                 name="categoryId" 
                 value={categoryId} 
                 onChange={ (e) => setcategoryId(e.target.value)} />
        </div>
        <div className="form-group mb-2" >
            <label className="form-label">Enter Category Name</label>
            <input 
                 type="text" 
                 className="form-control" 
                 name="categoryName" 
                 value={categoryName} 
                 onChange={ (e) => setcategoryName(e.target.value)} />
        </div>
        <button className="btn btn-success" onClick={(e) => addOrUpdateFood(e)}>Submit</button>
        <Link to="/food/viewallfodd" className="btn btn-danger">Cancel</Link>
        </form>
        </div>
        </div>
        </div>
        </div>


    );
}



export default AddFood;

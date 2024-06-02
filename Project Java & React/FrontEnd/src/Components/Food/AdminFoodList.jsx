
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import foodservice from '../Services/foodservice'



 const ListFood = () => {



 const [foods,setfoods] = useState([])

//      if (localStorage.getItem("admin") !== null)
//      {
//         document.getElementsByClassName("adminpage")
//      } 
//      else if (localStorage.getItem("customer") !== null)
//      {
//         Document.getElementsByClassName("customerpage")
//      }



useEffect(() => {
    getAllFoods();
}, [])

const getAllFoods =() => {
    foodservice.getAllFoods().then((response) => {
        setfoods(response.data)
        console.log(response.data)
    }).catch(error => {
        console.log(error)
    })
}


const deleteFood =(foodId) => {
    //console.log(foodId)
    foodservice.deleteFood(foodId).then((response) => {
    getAllFoods();
    }).catch((error) => {
        console.log(error)
    })
}


  return (
    <div>
  <div className='adminpage'> 
    <h2 className='text-center'> List Foods </h2>
    <Link to="/food/addfood" className="btn btn-primary w-1"> Add food </Link>
    <table class="table table-bordered table-striped">
    <thead>
                        <tr className='bg-dark text-white'>
                            <th>Food ID</th>
                            <th>Food Name</th>
                            <th>Food Description</th>
                            <th>Food Price</th>
                            <th> Actions</th> 
                        </tr>
    </thead>
    <tbody>
        {
            foods.map(
                food => 
            <tr key={food.foodId}>
                <td>{food.foodId}</td>
                <td>{food.name}</td>
                <td>{food.description}</td>
                <td>{food.price}</td>
                <td>
                    <Link className="btn btn-success m-2" to = {`/api/food/update/${food.foodId}`}>Update</Link>
                    <button className="btn btn-danger m-2" onClick={ () => deleteFood(food.foodId)}>Delete</button>

                </td>
            </tr>          
            )
        }
    </tbody>

    </table>
  </div>



  </div>



  )
}

export default ListFood
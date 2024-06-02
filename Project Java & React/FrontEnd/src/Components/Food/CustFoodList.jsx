
import React, { useEffect, useState } from 'react'

import foodservice from '../Services/foodservice'
import { Link, useParams } from 'react-router-dom'
import cartservice from '../Services/cartservice'



 const ListFood = () => {

     const [userId , setUserId] = useState([]);

    // const userId = () => {
    //     const setUserId =JSON.parse(localStorage.getItem("customer")).userId
    // }


    const [foods,setfoods] = useState([])
 
    const [quantity , setQuantity] = useState([])

   // const {userId} = useParams();

useEffect(()=>{
    const userId =JSON.parse(localStorage.getItem("customer")).userId
    if(userId){
        setUserId(userId)
    }
},[])


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




const addtocart =(quantity,foodId) => {
    var user = JSON.parse(window.localStorage.getItem("customer"))

    var userId = JSON.stringify(user.userId)

    const item ={
        foodId : foodId,
        quantity:quantity
    }

    console.log(item) 
    console.log(userId)

    cartservice.addToCart(userId,item)
}



  return (
    <div>
  <div className='adminpage'> 
    <h2 className='text-center'> List Foods </h2>
    <Link to={`/api/cart/getcart/${userId}`} className="btn btn-primary w-1 btn-lg float-right "> View Cart </Link>
    <table class="table table-bordered table-striped">
    <thead>
                        <tr className='bg-dark text-white'>
                            <th>Food ID</th>
                            <th>Food Name</th>
                            <th>Food Description</th>
                            <th>Food Price</th>
                            <th>Enter Quantity</th>
                            <th>Action</th>
                        </tr>
    </thead>
    <tbody>
        {
            foods.map(food => 
            <tr key={food.foodId}>
                <td>{food.foodId}</td>
                <td>{food.name}</td>
                <td>{food.description}</td>
                <td>{food.price}</td>
                <td>
                <form>
                    <div class="form-row">
                         <div class="col">
                         <input type="text" class="form-control" placeholder="Required Quantity" 
                          name="quantity" value={quantity} onChange={ (e) => setQuantity(e.target.value)} />
                         </div>
                    </div>
                </form>
                </td>
                <td> <button className="btn btn-success m-2" onClick={ () => addtocart(`${quantity}` , food.foodId)}>Add To Cart</button></td>
               
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
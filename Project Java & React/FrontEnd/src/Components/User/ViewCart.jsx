import React, { useEffect, useState } from 'react'
import cartservice from '../Services/cartservice'
import CartItems from './CartItems'

const ViewCart = () => {

     const [foods, setdata] = useState([])

     const userId = JSON.parse(localStorage.getItem("customer")).userId

    // console.log(userId)

    useEffect(() => {
        cartservice.viewcart(userId).then((response) => {
            setdata(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error)
        })
    }, [])

    

    //console.log(foods)

    // useEffect(() => {
    //     axios.get(`http://localhost:8080/api/cart/getcart/${userId}`).
    //     then((response) => {
    //         setfoods(response.data)
    //         console.log(response.data)
    //     }).catch(error => {
    //         console.log(error)
    //     })
    // }, [])

    var getitems = () => {foods.map((data) => {
        return <CartItems items={data}></CartItems>
    
    })}


    return (
        <div>
           <div>{() => getitems()} </div>
        </div>

        // <div>
        // <div className='adminpage'> 
        //   <h2 className='text-center'> List Foods </h2>
        //   <table class="table table-bordered table-striped">
        //   <thead>
        //                       <tr className='bg-dark text-white'>
        //                           <th>Food ID</th>
        //                           <th>Food Name</th>
        //                           <th>Food Description</th>
        //                           <th>Food Price</th>
        //                           <th> Actions</th> 
        //                       </tr>
        //   </thead>
        //   <tbody>
        //     {
        //         data.map(cart => {
        //             return (
        //                 <div key={cart.cartItemId}>
        //                     {cart.food.map(data => (
        //                         <div >
        //                     ))}
        //                     <h3>{food.name}</h3>
        //                     <h3>{food.price}</h3>
        //                     {

        //                     }

        //                 </div>
        //             )
        //         })
        //     }




    )
}

export default ViewCart
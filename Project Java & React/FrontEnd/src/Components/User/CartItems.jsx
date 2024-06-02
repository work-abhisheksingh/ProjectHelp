import React from 'react'

const CartItems = (props) => {

  var id = props.items.food.name
  console.log(id)






  return (
    <div>
    <div></div>
    <div class="container-fluid " style={{ "padding-top": "25px" }}>
        <div class="card bg-secondary"  >
            <div class="row">
        
            <div class="col-sm-6 ">
                            <div class="card-body">
                                <h4 class="card-title">Food Name ::{props.items.food.map((data) => {
                                    return data.name 
                                })}
                                </h4>

                                <h4 class="card-title">Food Price ::{props.items.food.map((data) => {
                                    return data.price 
                                })}
                                </h4>

                                <p class="card-text"> Food Quantity  ::{props.items.quantity}
                                </p>

                                <p class="card-text"> Total Price  ::{props.items.totalPrice}
                                </p>
                                </div>

                                <button class="btn btn-success" >Change Status</button>
                        </div>
                        <div class="col-sm-6">
                            <div class="card-body">


                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>    
  )
}

export default CartItems
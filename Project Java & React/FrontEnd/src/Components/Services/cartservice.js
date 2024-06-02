
import httpCommon from "../../http-common"

class cartservice{

    addToCart(userId , item){
        return httpCommon.post('/cart/addtocart/'+userId ,item)
    }

    viewcart(userId){
        return httpCommon.get('/cart/getcart/'+userId)
    }

}

export default new cartservice
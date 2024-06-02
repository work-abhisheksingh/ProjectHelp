
import httpCommon from "../../http-common"

class foodservice {

    getAllFoods(){
        return httpCommon.get('/food/viewall');
    }

    addFood (food){
        return httpCommon.post('/food/addfood',food);
    }

    getFoodById(foodId){
        return httpCommon.get('/food/viewbyid/'+foodId)
    }

    updateFood(foodId , food){
        return httpCommon.put('/food/update/'+foodId , food)
    }

    deleteFood(foodId){
        return httpCommon.delete('/food/delete/'+foodId)
    }

}




// const add= (data) => {
//     return httpCommon.post('/addfood',data);
// };

// const getall = () => {
//     return httpCommon.get('/viewall');
// };

// const getFoodById = (foodId) => {
//     return httpCommon.get('/viewbyid',foodId);
// }


export default new foodservice();
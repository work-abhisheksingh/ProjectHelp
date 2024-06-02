
import httpCommon from "../../http-common"

class userservice {

    adduser (user){
        return httpCommon.post('/user/adduser',user)
    }

    signin (user){
        return httpCommon.post('/user/signin',user)
    }

}
export default new userservice();
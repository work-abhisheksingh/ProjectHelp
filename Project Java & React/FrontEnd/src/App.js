
import './App.css';


import Header from './Components/User/Header'
import About from './Components/Pages/AboutUs'
import Contact from './Components/Pages/ContactUs';
import PageNotFound from './Components/Pages/PageNotFound';
import AddFood from './Components/Food/AddFood';

import Register  from './Components/User/Register';
import Login from './Components/User/Login';

import {BrowserRouter as Router , Route,Switch} from 'react-router-dom';


import AdminFoodList from './Components/Food/AdminFoodList';
import CustFoodList from './Components/Food/CustFoodList';

import ViewCart from './Components/User/ViewCart';




function App() {
  return (
   <Router>
     <div className="App">
      <Header/>

      <Switch>                         // - page not found must be at last
        <Route exact path="/" component={AdminFoodList}></Route>
        <Route exact path="/food/viewallfood" component={CustFoodList}></Route>
    
        <Route exact path="/about" component={About}></Route>
        <Route exact path="/contact" component={Contact}></Route>
        <Route exact path='/food/addfood' component={AddFood}></Route>
        <Route exact path='/api/food/update/:foodId' component={AddFood}></Route>
        <Route exact path='/api/food/delete/:foodId' component={AddFood}></Route>

        <Route exact path='/api/user/adduser' component={Register}></Route>
        <Route exact path='/api/user/signin' component={Login}></Route>

        <Route exact path='/api/cart/getcart/:userId' component={ViewCart}></Route>

        <Route exact path='*' component={PageNotFound}></Route>
        
      </Switch>
      
    </div>
   </Router>
  );
}

export default App;

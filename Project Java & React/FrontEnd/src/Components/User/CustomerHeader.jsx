import React from 'react'
import {Container , Navbar , Dropdown, Nav, Badge} from "react-bootstrap"
import DropdownMenu from 'react-bootstrap/esm/DropdownMenu'
import { Link } from 'react-router-dom'
import {FaShoppingCart} from 'react-icons/fa'

const CustomerHeader = () => {
  return (
    <Navbar bg="warning" variant ="dark" style={{height :80}}>
        <Container>
            <Navbar.Brand>
                <Link to="/food/viewallfood" ></Link>
            </Navbar.Brand>
            <Navbar.Text className='Search'>
            </Navbar.Text>
            <Nav>
                <Dropdown alignRight>
                    <Dropdown.Toggle variant = "success">
                        <FaShoppingCart color ="white" fontSize= "40px"/>
                        <Badge></Badge>
                    </Dropdown.Toggle>
                    <DropdownMenu style = {{minWidth : 370}}>
                        <span style={{padding:10}}>Cart is Empty !!!</span>
                    </DropdownMenu>

                </Dropdown>
            </Nav>
        </Container>
    </Navbar>
  )
}

export default CustomerHeader
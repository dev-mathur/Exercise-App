import React from 'react'
import { useLocation } from 'react-router-dom';
import axios from 'axios';
export default function DataForm (props) {
    const location = useLocation();
    const { title, id, date, name, duration, caloriesBurnt } = location.state;
    return (
    <div className='container'>
        <h1>{title}</h1>
    <form>
        <div class="form-group">
        <label for="exampleInputEmail1">Date</label>
        <input type="text" value={date} onChange={e => this.setState({ text: e.target.value })} class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"></input>
        </div>
        <div class="form-group">
        <label for="exampleInputPassword1">Exercise</label>
        <input type="text" value={name} onChange={e => this.setState({ text: e.target.value })} class="form-control" id="exampleInputPassword1" placeholder="Password"></input>
        </div>
        <div class="form-group">
        <label for="exampleInputPassword1">Duration</label>
        <input type="number" value={duration} onChange={e => this.setState({ text: e.target.value })} class="form-control" id="exampleInputPassword1" placeholder="Password"></input>
        </div>
        <div class="form-group">
        <label for="exampleInputPassword1">Calories Burnt</label>
        <input type="number" value={caloriesBurnt} onChange={e => this.setState({ text: e.target.value })} class="form-control" id="exampleInputPassword1" placeholder="Password"></input>
        </div>
        <a href='http://localhost:3000/'><button type="submit" class="btn btn-primary" onClick={axios.put(`http://localhost:8080/exercise/${id}`,{date: date, name: name, 
        duration: duration, caloriesBurnt: caloriesBurnt})}>Submit</button></a>
    </form>
    </div>
    );
}

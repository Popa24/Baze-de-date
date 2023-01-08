


import axios from "axios";
import {useEffect, useState} from "react";
import "./PersoanaComponent.css";
class Autor {
    constructor(id_carte,id_aut) {
        this.id_carte=id_carte;
        this.id_aut=id_aut;
    }}

function AutorComponent() {
    async function getAutori() {
        try {
            const response = await axios.get('http://localhost:8080/autor');
            setautor(response.data.map(p => new Autor(p.id_carte, p.id_aut)));
            settitluriautor(["ID Carte", "ID Autor"]);

            console.log(autor);
        } catch (error) {
            console.error(error);
        }
    }
    async function getPerechi() {
        try {
            const response = await axios.get('http://localhost:8080/autor/perechi');
            setautor(response.data.map(p => new Autor(p[0], p[1])));
            settitluriautor(["ID Autor 1", "ID Autor 2"]);

            console.log(response.data);
            console.log(autor);
        } catch (error) {
            console.error(error);
        }
    }
    const [autor,setautor]=useState([]);
    const [titluriautor,settitluriautor]=useState(["ID Carte","ID Autor"]);
    useEffect(()=>{getAutori()},[])
    return (
        <>
            <div  >
                <form className="center2 " onChange={event => {if(event.target.value==="4b"){getPerechi()} else {getAutori()}}}>

                    <input
                        type="text"
                        placeholder="Search..."


                    />
                    <button type="submit">Search</button>
                </form>
            </div>
        <div className="center">
           <table className="persoana-table" >

            <thead>
            <tr>
                <th colSpan={5} id="numetabel"> Tabel Autori</th>
            </tr>
            <tr key={titluriautor[0]}>
                <th>{titluriautor[0]}</th>
                <th>{titluriautor[1]}</th>
            </tr>
            </thead>
            <tbody>
            {autor.map(p => (
                <tr key={p.id_carte}>
                    <td>{p.id_carte}</td>
                    <td>{p.id_aut}</td>
                </tr>
            ))}
            </tbody>
        </table></div></>
    );
}

export default AutorComponent;

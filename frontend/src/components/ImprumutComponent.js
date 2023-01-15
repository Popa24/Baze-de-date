


import axios from "axios";
import {useEffect, useState} from "react";
import "./PersoanaComponent.css";
class Imprumut {
    constructor(id_carte,id_imp, datai, datar, nr_zile) {
        this.id_carte=id_carte;
        this.id_imp= id_imp;
        this.datai = datai;
        this.datar = datar;
        this.nr_zile = nr_zile;
    }}

function ImprumutComponent() {
    async function getImprumuturi() {
        try {
            const response = await axios.get('http://localhost:8080/imprumut');
            setimprumut(response.data.map(p => new Imprumut(p.id_carte, p.id_imp, p.datai, p.datar, p.nr_zile)));
            console.log(imprumut);
        } catch (error) {
            console.error(error);
        }
    }
    async function getImpumuturiNerestituite() {
        try {
            const response = await axios.get('http://localhost:8080/imprumut/nerestituite');
            setimprumut(response.data.map(p => new Imprumut(p.id_carte, p.id_imp, p.datai, p.datar, p.nr_zile)));
            console.log(response.data);
            console.log(imprumut);
        } catch (error) {
            console.error(error);
        }
    }
    const [imprumut,setimprumut]=useState([]);
    useEffect(()=>{getImprumuturi()},[])
    return (
        <>
            <div  >
                <form className="center2 " onChange={event => {if(event.target.value==="3b"){getImpumuturiNerestituite()} else {getImprumuturi()}}}>

                    <input
                        type="text"
                        placeholder="Search..."


                    />
                    <button type="submit">Search</button>
                </form>
            </div>
        <div className="center"><table className="persoana-table" >

            <thead>
            <tr>
                <th colSpan={5} id="numetabel"> Tabel Imprumuturi</th>
            </tr>
            <tr>
                <th>ID Carte</th>
                <th>ID Imprumutator</th>
                <th>Data Imprumut</th>
                <th>Data Restituire</th>
                <th>Numar zile</th>
            </tr>
            </thead>
            <tbody>
            {imprumut.map(p => (
                <tr key={p.id_carte}>
                    <td>{p.id_carte}</td>
                    <td>{p.id_imp}</td>
                    <td>{p.datai}</td>
                    <td>{p.datar}</td>
                    <td>{p.nr_zile}</td>
                </tr>
            ))}
            </tbody>
        </table></div></>
    );
}

export default ImprumutComponent;

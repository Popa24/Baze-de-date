


import axios from "axios";
import {useEffect, useState} from "react";
import "./PersoanaComponent.css";
class Carte {
    constructor(id_carte,titlu, nr_pagini, nr_exemplare, gen) {
        this.id_carte=id_carte;
        this.titlu = titlu;
        this.nr_pagini = nr_pagini;
        this.nr_exemplare = nr_exemplare;
        this.gen = gen;
    }}
class Carte2 {
    constructor( gen, nr_pagini_mediu, nr_pagini_minim,nr_pagini_maxim) {
        this.nr_pagini_mediu= nr_pagini_mediu;
        this.nr_pagini_minim= nr_pagini_minim;
        this.nr_pagini_maxim = nr_pagini_maxim;
        this.gen = gen;
    }}
function createCarteRow(carte){
    return(
        <tr>
            <td>{carte.id_carte}</td>
            <td>{carte.titlu}</td>
            <td>{carte.nr_pagini}</td>
            <td>{carte.nr_exemplare}</td>
            <td>{carte.gen}</td>
        </tr>
    )
}
function createCarte2Row(carte){
    return(
        <tr>
            <td>{carte.gen}</td>
            <td>{carte.nr_pagini_mediu}</td>
            <td>{carte.nr_pagini_minim}</td>
            <td>{carte.nr_pagini_maxim}</td>
        </tr>
    )
}


function CarteComponent() {

    async function getCarti() {
        try {
            const response = await axios.get('http://localhost:8080/carte');
            setcarte(response.data.map(p => new Carte(p.id_carte, p.titlu, p.nr_pagini, p.nr_exemplare, p.gen)));
            setcartemediu(["ID","Titlu","Numar pagini","Numar exemplare","gen"])
            console.log(carte);
        } catch (error) {
            console.error(error);
        }
    }
    async function getCartiExemplare() {
        try {
            const response = await axios.get('http://localhost:8080/carte/exemplare');
            setcarte(response.data.map(p => new Carte(p.id_carte, p.titlu, p.nr_pagini, p.nr_exemplare, p.gen)));
            console.log(carte);
        } catch (error) {
            console.error(error);
        }
    }
    async function getCarteShogun() {
        try {
            const response = await axios.get('http://localhost:8080/carte/shogun');
            setcarte(response.data.map(p => new Carte(p.id_carte, p.titlu, p.nr_pagini, p.nr_exemplare, p.gen)));
            console.log(carte);
        } catch (error) {
            console.error(error);
        }
    }
    async function getCarteMediu() {
        try {
            const response = await axios.get('http://localhost:8080/carte/mediu');
            setcarte(response.data.map(p => new Carte2(p[0],p[1],p[2],p[3],p[4])));
            setcartemediu(["gen","Pagini minime","Pagini maxime","Pagini Medii"])
            console.log(carte);
            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
    }
    const [carte,setcarte]=useState([]);
    const[cartemediu,setcartemediu]=useState(["ID","Titlu","Numar pagini","Numar exemplare","gen"])
    const [search,setsearch]=useState("");
    useEffect(()=>{
        getCarti();
    },[])
    useEffect(()=>{
        getData();
    },[search])
    function getData(){
        switch (search){
            case "3a": return   getCartiExemplare();
            case "5a": return   getCarteShogun();
            case "6b": return  getCarteMediu();
            default : return getCarti();
        }
    }
    return (
    <>
        <div  >
            <form className="center2 " onChange={
                event=>{setsearch(event.target.value)}
            //     event => {if(event.target.value==="3a")
            // {getCartiExemplare()}
            // else if(event.target.value==="5a"){getCarteShogun()}else if(event.target.value==="6a"){getCarteMediu()}else
            //     {getCarti()}
            // }

            }>

                <input
                    type="text"
                    placeholder="Search..."


                />
                <button type="submit">Search</button>
            </form>
        </div>
        <div className="center">

            <table className="persoana-table" >

            <thead  >
            <tr>
                <th colSpan={5} id="numetabel"> Tabel Carti</th>
            </tr><tr className="persoana-table_green">
            { cartemediu.map((header) => <td  >{header}</td>)}</tr>
            </thead>
            <tbody>

            {
               carte.map(
                   carte=>{
                       console.log("carte ",carte);

                       return carte instanceof Carte? createCarteRow(carte):createCarte2Row(carte);
                   }
               )

            }
            </tbody>
        </table></div></>
    );
}

export default CarteComponent;

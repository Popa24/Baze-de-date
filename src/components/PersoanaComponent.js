


import axios from "axios";
import {useEffect, useState} from "react";
import "./PersoanaComponent.css";
class Persoana {
    constructor(id_pers,nume, telefon, adresa, data_nasterii) {
        this.id_pers=id_pers;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
    }}
class Persoana2 {
    constructor(id_pers,nume, telefon, adresa, data_nasterii,intarziere) {
        this.id_pers=id_pers;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
        this.intarziere=intarziere;
    }}
class Persoana3 {
    constructor(id_pers,nume, telefon, adresa, data_nasterii,id_carte,titlu, nr_pagini, nr_exemplare, gen) {
        this.id_pers=id_pers;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
        this.id_carte=id_carte;
        this.titlu = titlu;
        this.nr_pagini = nr_pagini;
        this.nr_exemplare = nr_exemplare;
        this.gen = gen;
    }}
function createPersoanaRow(persoana){
    return(
        <tr>
            <td>{persoana.id_pers}</td>
            <td>{persoana.nume}</td>
            <td>{persoana.telefon}</td>
            <td>{persoana.adresa}</td>
            <td>{persoana.data_nasterii}</td>

        </tr>
    )
}


function createPersoanaHeader2(persoana){
    return(
        <tr>
            <td>{persoana.id_pers}</td>
            <td>{persoana.nume}</td>
            <td>{persoana.telefon}</td>
            <td>{persoana.adresa}</td>
            <td>{persoana.data_nasterii}</td>
            <td>{persoana.intarziere}</td>

        </tr>
    )
}
function createPersoanaHeader3(persoana){
    return(
        <tr>
            <td>{persoana.id_pers}</td>
            <td>{persoana.nume}</td>
            <td>{persoana.telefon}</td>
            <td>{persoana.adresa}</td>
            <td>{persoana.data_nasterii}</td>
            <td>{persoana.id_carte}</td>
            <td>{persoana.titlu}</td>
            <td>{persoana.nr_pagini}</td>
            <td>{persoana.nr_exemplare}</td>
            <td>{persoana.gen}</td>


        </tr>
    )
}
function PersoanaComponent() {
    async function getPersoane() {
        try {
            const response = await axios.get('http://localhost:8080/persoana');
            setpersoana(response.data.map(p => new Persoana(p.id_pers, p.nume, p.telefon, p.adresa, p.data_nasterii)));
            setpersoana1(["Id Persoana","Nume","Telefon","Adresa","Data Nasterii"])
            console.log(persoana);
        } catch (error) {
            console.error(error);
        }
    }
    async function getAllNrExemplare() {
        try {
            const response = await axios.get('http://localhost:8080/persoana/nerestituite2');
            setpersoana(response.data.map(p => new Persoana3(p[0].id_pers, p[0].nume, p[0].telefon, p[0].adresa,p[0].data_nasterii, p[1].id_carte,p[1].titlu,p[1].nr_pagini,p[1].nr_exemplare,p[1].gen)));
            setpersoana1(["Id Persoana","Nume","Telefon","Adresa","Data Nasterii","ID","Titlu","Numar pagini","Numar exemplare","gen"])
            console.log(persoana);
        } catch (error) {
            console.error(error);
        }
    }
    async function getAllCopii() {
        try {
            const response = await axios.get('http://localhost:8080/persoana/date');
            setpersoana(response.data.map(p => new Persoana(p.id_pers, p.nume, p.telefon, p.adresa, p.data_nasterii)));
            console.log(persoana);
        } catch (error) {
            console.error(error);
        }
    }
    async function getAllIntarziere() {
        try {
            const response = await axios.get('http://localhost:8080/persoana/nerestituite1');
            setpersoana(response.data.map(p => new Persoana2(p[0],p[1],p[2],p[3],p[4],p[5])));
            setpersoana1(["Id Persoana","Nume","Telefon","Adresa","Data Nasterii","Intarziere"])
            console.log(persoana);
        } catch (error) {
            console.error(error);
        }
    }
    const [persoana,setpersoana]=useState([]);
    const[persoana1,setpersoana1]=useState(["Id Persoana","Nume","Telefon","Adresa","Data Nasterii"]);
    const [search,setsearch]=useState("");
    useEffect(()=>{getPersoane()},[])
    useEffect(()=>{
        getData();
    },[search])

    function getData(){
        switch (search){
            case "4a": return   getAllCopii();
            case "6a": return   getAllIntarziere();
            case "5b": return  getAllNrExemplare();
            default : return getPersoane();
        }
    }
    return (
        <>
            <div  >
                <form className="center2 " onChange={ event=>{setsearch(event.target.value)}}>

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
                <th colSpan={10} id="numetabel"> Tabel Persoane</th>
            </tr><tr className="persoana-table_green">
                { persoana1.map((header) => <td  >{header}</td>)}</tr>
            </thead>
            <tbody>
            {
                persoana.map(
                    persoana=>{
                        console.log("persoana ",persoana);
                        if(persoana instanceof Persoana){
                            return createPersoanaRow(persoana);
                        } else if(persoana instanceof Persoana2){
                            return  createPersoanaHeader2(persoana);
                        }else if(persoana instanceof Persoana3){
                            return createPersoanaHeader3(persoana);
                        }

                    }
                )

            }
            </tbody>
        </table></div></>
    );
}

export default PersoanaComponent;

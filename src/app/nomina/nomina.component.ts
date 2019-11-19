import { Component, OnInit } from '@angular/core';
import { Nomina } from '../nomina';
import { NominaService } from '../nomina.service';

@Component({
  selector: 'app-nomina',
  templateUrl: './nomina.component.html',
  styleUrls: ['./nomina.component.css']
})
export class NominaComponent implements OnInit {

  nominasList: Nomina[];

  constructor(private nominaService: NominaService) { }

  ngOnInit() {
    this.nominaService.getNominas().subscribe(data => {
      this.nominasList = data;
    })
  }

}

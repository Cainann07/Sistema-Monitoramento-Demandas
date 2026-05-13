import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { DemandaService } from '../../services/demanda';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-tela-principal',
  standalone: true,
  imports: [CommonModule, ButtonModule, FormsModule, DialogModule, InputTextModule],
  templateUrl: './tela_principal.component.html',
  styleUrl: './tela_principal.component.scss'
})

export class TelaPrincipalComponent implements OnInit {
  constructor(private demandaService: DemandaService) { }

  exibirModal: boolean = false;
  novaDemanda = { nome: '', status: 'EM_ANDAMENTO' };
  demandas$!: Observable<any[]>; // O '$' indica que é um Observable

  ngOnInit(): void {
    this.listarDemandas();
  }

  // No seu arquivo .ts
  carregando: boolean = true;

  listarDemandas(): void {
    this.demandas$ = this.demandaService.listar(); // Atribui o fluxo diretamente
}

  salvarDemanda() {
    this.demandaService.inserir(this.novaDemanda).subscribe({
      next: () => {
        this.exibirModal = false;
        this.novaDemanda = { nome: '', status: 'EM_ANDAMENTO' };
        this.listarDemandas();
      },
      error: (err) => console.error(err)
    });
  }

  abrirModal() {
    this.exibirModal = true;
  }

}
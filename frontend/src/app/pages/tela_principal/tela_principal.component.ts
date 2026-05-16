import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { DemandaService } from '../../services/demanda';
import { FormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { BehaviorSubject, Observable } from 'rxjs';
import { StatusDemanda } from '../../enums/status-demanda.enum';
import { Demanda } from '../../model/demanda.model';
import { SelectModule } from 'primeng/select';

@Component({
  selector: 'app-tela-principal',
  standalone: true,
  imports: [CommonModule, ButtonModule, FormsModule, DialogModule, InputTextModule, SelectModule],
  templateUrl: './tela_principal.component.html',
  styleUrl: './tela_principal.component.scss'
})

export class TelaPrincipalComponent implements OnInit {
  constructor(private demandaService: DemandaService, private cd: ChangeDetectorRef) { }

  exibirModal: boolean = false;
  exibirModalEdicao: boolean = false;
  
  private demandasSubject = new BehaviorSubject<any[]>([]);
  demandas$ = this.demandasSubject.asObservable(); opcoesStatus = Object.values(StatusDemanda);

  novaDemanda = { nome: '', status: StatusDemanda.EM_ANDAMENTO };
  demandaEditada: Demanda = { id: undefined, nome: '', status: StatusDemanda.EM_ANDAMENTO };

  ngOnInit(): void {
    this.listarDemandas();
  }

  prepararEdicao(demandaSelecionada: Demanda) {
    this.demandaEditada = { ...demandaSelecionada };
    this.abrirModalEdicao();
  }

  carregando: boolean = true;

  listarDemandas(): void {
    this.demandaService.listar().subscribe({
      next: (dados) => {
        this.demandasSubject.next(dados); 
        this.cd.detectChanges();
      },
      error: (err) => console.error('Erro ao listar demandas:', err)
    });
  }

  salvarDemanda() {
    this.demandaService.inserir(this.novaDemanda).subscribe({
      next: () => {
        this.exibirModal = false;
        this.cd.detectChanges();
        this.novaDemanda = { nome: '', status: StatusDemanda.EM_ANDAMENTO };
        this.listarDemandas();
      },
      error: (err) => console.error(err)
    });
  }

  editarDemanda() {

    if (!this.demandaEditada.id) {
      console.error('Não é possível editar uma demanda sem ID.');
      return;
    }

    this.demandaService.atualizar(this.demandaEditada).subscribe({
      next: () => {
        this.exibirModalEdicao = false;
        this.cd.detectChanges();

        this.demandaEditada = { id: undefined, nome: '', status: StatusDemanda.EM_ANDAMENTO };
        this.listarDemandas();
      },
      error: (err) => console.error(err)
    });
  }

  excluirDemanda(id: number) {
    this.demandaService.excluir(id).subscribe({
      next: () => {
        this.listarDemandas();
      },
      error: (err) => console.error(err)
    });
  }

  abrirModalInsercao() {
    this.exibirModal = true;
  }

  abrirModalEdicao() {
    this.exibirModalEdicao = true;
  }

}
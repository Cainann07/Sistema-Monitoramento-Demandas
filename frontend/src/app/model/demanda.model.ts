export interface Demanda {
    id?: number; // O '?' indica que é opcional (o banco gera o ID)
    nome: string;
    status: string;
}
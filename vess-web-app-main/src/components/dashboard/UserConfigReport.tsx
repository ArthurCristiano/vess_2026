"use client";

import { useState, useEffect } from "react";
import { Table, TableBody, TableCell, TableHeader, TableRow } from "../ui/table";
import { Eye } from "lucide-react";
import api from "../../services/api";
import Modal from "../common/Modal";

interface Configuracao {
  id: number;
  nome: string;
  email: string;
  pais: string;
  cidadeEestado: string;
  dataCriacao: string;
}

export default function ConfiguracaoReport() {
  const [configuracoes, setConfiguracoes] = useState<Configuracao[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedConfig, setSelectedConfig] = useState<Configuracao | null>(null);

  useEffect(() => {
    const fetchConfiguracoes = async () => {
      try {
        setLoading(true);
        const response = await api.get("/configuracao");
        setConfiguracoes(response.data);
      } catch (err) {
        setError("Falha ao buscar as configurações do servidor.");
        console.error(err);
      } finally {
        setLoading(false);
      }
    };
    fetchConfiguracoes();
  }, []);

  const handleViewClick = (config: Configuracao) => {
    setSelectedConfig(config);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
    setSelectedConfig(null);
  };

  return (
    <>
      <div className="overflow-hidden rounded-2xl border border-gray-200 bg-white px-4 pb-3 pt-4 dark:border-gray-800 dark:bg-gray-900 sm:px-6 shadow-sm">
        <div className="mb-4 flex flex-col gap-2 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <h3 className="text-lg font-semibold text-gray-800 dark:text-white/90">
              Relatório de Configurações
            </h3>
            <p className="text-sm text-gray-500 dark:text-gray-400">
              Visualize as configurações cadastradas no sistema.
            </p>
          </div>
        </div>

        <div className="max-w-full overflow-x-auto">
          <Table className="w-full table-fixed">
            <TableHeader className="border-y border-gray-100 dark:border-gray-800">
              <TableRow>
                <TableCell isHeader className="px-4 py-3 text-start font-medium text-gray-500 text-theme-xs dark:text-gray-400">
                  Nome
                </TableCell>
                <TableCell isHeader className="px-4 py-3 text-start font-medium text-gray-500 text-theme-xs dark:text-gray-400">
                  Email
                </TableCell>
                <TableCell isHeader className="px-4 py-3 text-start font-medium text-gray-500 text-theme-xs dark:text-gray-400">
                  País
                </TableCell>
                <TableCell isHeader className="px-4 py-3 text-start font-medium text-gray-500 text-theme-xs dark:text-gray-400">
                  Cidade / Estado
                </TableCell>
                <TableCell isHeader className="px-4 py-3 text-start font-medium text-gray-500 text-theme-xs dark:text-gray-400">
                  Data de Criação
                </TableCell>
                <TableCell isHeader className="px-4 py-3 text-center font-medium text-gray-500 text-theme-xs dark:text-gray-400">
                  Visualizar
                </TableCell>
              </TableRow>
            </TableHeader>

            <TableBody className="divide-y divide-gray-100 dark:divide-gray-800">
              {loading ? (
                <TableRow>
                  <TableCell
                    className="px-4 py-6 text-center text-gray-500 dark:text-gray-400"
                  >
                    Carregando configurações...
                  </TableCell>
                </TableRow>
              ) : error ? (
                <TableRow>
                  <TableCell
                    className="px-4 py-6 text-center text-red-500"
                  >
                    {error}
                  </TableCell>
                </TableRow>
              ) : configuracoes.length === 0 ? (
                <TableRow>
                  <TableCell
                    className="px-4 py-6 text-center text-gray-500 dark:text-gray-400"
                  >
                    Nenhuma configuração encontrada.
                  </TableCell>
                </TableRow>
              ) : (
                configuracoes.map((config) => (
                  <TableRow key={config.id} className="hover:bg-gray-50 dark:hover:bg-gray-800/50 transition-colors">
                    <TableCell className="px-4 py-3 font-medium text-gray-800 text-theme-sm dark:text-white/90 truncate max-w-[180px]" >
                      {config.nome}
                    </TableCell>
                    <TableCell className="px-4 py-3 text-gray-500 text-theme-sm dark:text-gray-400 truncate max-w-[220px]">
                      {config.email}
                    </TableCell>
                    <TableCell className="px-4 py-3 text-gray-500 text-theme-sm dark:text-gray-400">
                      {config.pais}
                    </TableCell>
                    <TableCell className="px-4 py-3 text-gray-500 text-theme-sm dark:text-gray-400">
                      {config.cidadeEestado}
                    </TableCell>
                    <TableCell className="px-4 py-3 text-gray-500 text-theme-sm dark:text-gray-400">
                      {new Date(config.dataCriacao).toLocaleDateString("pt-BR")}
                    </TableCell>
                    <TableCell className="px-4 py-3 text-center">
                      <button
                        onClick={() => handleViewClick(config)}
                        className="text-blue-600 hover:text-blue-800 dark:text-blue-400 dark:hover:text-blue-300 transition-colors"
                        title="Visualizar detalhes"
                      >
                        <Eye size={18} />
                      </button>
                    </TableCell>
                  </TableRow>
                ))
              )}
            </TableBody>
          </Table>
        </div>
      </div>

      <Modal
        isOpen={isModalOpen}
        onClose={handleCloseModal}
        title={selectedConfig ? `Detalhes de: ${selectedConfig.nome}` : "Detalhes"}
      >
        {selectedConfig && (
          <div className="space-y-3 text-gray-700 dark:text-gray-300 text-sm">
            <p><strong>ID:</strong> {selectedConfig.id}</p>
            <p><strong>Email:</strong> {selectedConfig.email}</p>
            <p><strong>País:</strong> {selectedConfig.pais}</p>
            <p><strong>Cidade / Estado:</strong> {selectedConfig.cidadeEestado}</p>
            <p>
              <strong>Data de Criação:</strong>{" "}
              {new Date(selectedConfig.dataCriacao).toLocaleString("pt-BR")}
            </p>
          </div>
        )}
      </Modal>
    </>
  );
}

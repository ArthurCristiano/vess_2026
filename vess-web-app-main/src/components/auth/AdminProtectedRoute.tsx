import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../../context/AuthContext'; 

const AdminProtectedRoute: React.FC = () => {
    const { user, loading } = useAuth();

    if (loading) {
        return (
            <div className="flex justify-center items-center h-screen">
                <p>Verificando permissões...</p>
            </div>
        );
    }

    if (!user || !user.admin) {
        console.warn("Tentativa de acesso não autorizado a rota de admin.");
        return <Navigate to="/" replace />;
    }

    return <Outlet />;
};

export default AdminProtectedRoute;
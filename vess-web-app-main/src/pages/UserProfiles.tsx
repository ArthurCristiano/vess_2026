import UserInfoCard from "../components/UserProfile/UserInfoCard";
import PageMeta from '../components/common/PageMeta';

export default function UserProfiles() {
  return (
    <>
      <PageMeta
        title="Perfil do Usuário | Sua Aplicação"
        description="Página de perfil do usuário"
      />
      <div className="rounded-2xl border border-gray-200 bg-white p-5 dark:border-gray-800 dark:bg-gray-900 lg:p-6">
        <h3 className="mb-5 text-lg font-semibold text-gray-800 dark:text-white/90 lg:mb-7">
          Seu Perfil
        </h3>
        <div className="space-y-6">
          <UserInfoCard />
        </div>
      </div>
    </>
  );
}
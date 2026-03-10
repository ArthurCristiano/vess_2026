import { useTheme } from "../../context/ThemeContext";
import { Sun, Moon } from "lucide-react";

export const ThemeToggleButton: React.FC = () => {
  const { toggleTheme } = useTheme();

  return (
    <button
      onClick={toggleTheme}
      className="relative flex items-center justify-center text-black transition-colors bg-white border border-gray-200 rounded-full hover:text-dark-900 h-11 w-11 hover:bg-gray-100 hover:text-gray-700 dark:border-gray-800 dark:bg-gray-900 dark:text-gray-400 dark:hover:bg-gray-800 dark:hover:text-white"
    >
      <Sun
        size={20}
        color="black"
        className="block dark:hidden text-black"
      />
      <Moon
        size={20}
        className="hidden dark:block"
      />
    </button>
  );
};
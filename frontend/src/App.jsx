import BmiEdit from "./components/bmis/BmiEdit";
import Bmis from "./components/bmis/Bmis";

export default function App() {
  return (
    <main className="bg-blue-900 border-blue-300 h-screen flex flex-col items-center justify-center">
      <section className="container  inline-flex flex-col gap-6">
        <BmiEdit />
        <Bmis />
      </section>
    </main>
  )
}
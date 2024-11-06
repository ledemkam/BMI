import { useForm } from "react-hook-form"
import * as yup from "yup"
import { yupResolver } from "@hookform/resolvers/yup"

const schema = yup.object({
  account: yup.object({
    email: yup.string().email().required(),
  }).required(),
  height: yup.number().positive().required(),
  weight: yup.number().positive().required(),
})

const BmiEdit = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
  })

  const onSubmit = (data) => console.log(data)

  return (
    <div className="">
        <h3 className="flex items-center justify-between text-white  py-2 border-b border-white text-2xl font-bold ">
           Ihr BMI rechnen
        </h3>
        <form onSubmit={handleSubmit(onSubmit)} className="bg-slate-50 p-4 my-4 rounded-md">
          <div className="flex flex-col gap-3 my-3">
            <label htmlFor="height" className="text-sm font-bold">Ihre Größe(cm)</label>
            <input
              id="height"
              type="number"
              className="border-gray-700 shadow-sm rounded-lg text-sm"
              {...register("height", { required: true })}
            />
            {errors.height && <span className="text-sm font-medium text-red-700">Ihre Größe ist erforderlich</span>}
          </div>
          <div className="flex flex-col gap-3 my-3">
            <label htmlFor="weight" className="text-sm font-bold">Ihr Gewicht(cm)</label>
            <input
              id="weight"
              type="number"
              className="border-gray-700 shadow-sm rounded-lg text-sm"
              {...register("weight", { required: true })}
            />
            {errors.weight && <span className="text-sm font-medium text-red-700">Ihr Gewicht ist erforderlich</span>}
          </div>
          <div className="flex flex-col gap-3 my-3">
            <label htmlFor="bmi" className="text-sm font-bold">Ihr Email:</label>
            <input
              id="email"
              type="email"
              className="border-gray-700 shadow-sm rounded-lg text-sm"
              {...register("account.email", { required: true })}
            />
            {errors.account?.email && <span className="text-sm font-medium text-red-700">Ihr Email ist erforderlich</span>}
          </div>

      <button type="submit" className="w-full bg-blue-900 text-white text-center text-sm py-2 border-2 rounded-lg px-2 mt-3 font-semibold">Rechnen</button>
    </form>
    </div>
  )
}
export default BmiEdit